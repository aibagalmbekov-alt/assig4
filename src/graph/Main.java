package graph;

import graph.scc.*;
import graph.topo.*;
import graph.dagsp.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File dataFolder = new File("data"); // папка с JSON файлами
        File[] files = dataFolder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            System.out.println("❌ No JSON files found in /data folder");
            return;
        }

        System.out.println("📁 Found " + files.length + " JSON files.");

        try (PrintWriter writer = new PrintWriter(new FileWriter("results.csv"))) {
            // Заголовок CSV
            writer.println("n,scc_ms,topo_ms,short_ms,long_ms");

            // Перебираем все JSON файлы
            for (File file : files) {
                System.out.println("⚙️ Processing: " + file.getName());

                Graph g = GraphUtils.loadFromJson(file.getPath());
                if (g == null || g.getVertices().isEmpty()) {
                    System.out.println("⚠️ Skipping " + file.getName() + " (empty or invalid)");
                    continue;
                }

                int n = g.getVertices().size();
                double sccTime, topoTime, shortTime, longTime;
                long start, end;

                // === SCC ===
                start = System.nanoTime();
                SCCResult scc = SCCFinder.findSCC(g);
                end = System.nanoTime();
                sccTime = (end - start) / 1_000_000.0;

                // === Topo Sort ===
                start = System.nanoTime();
                TopoResult topo = TopologicalSort.sort(g);
                end = System.nanoTime();
                topoTime = (end - start) / 1_000_000.0;

                // === Shortest Path ===
                start = System.nanoTime();
                PathResult shortest = DAGShortestPath.find(g, "A");
                end = System.nanoTime();
                shortTime = (end - start) / 1_000_000.0;

                // === Longest Path ===
                start = System.nanoTime();
                PathResult longest = DAGLongestPath.find(g, "A");
                end = System.nanoTime();
                longTime = (end - start) / 1_000_000.0;

                // === Запись в CSV ===
                writer.printf(Locale.US, "%d,%.2f,%.2f,%.2f,%.2f%n", n, sccTime, topoTime, shortTime, longTime);

                System.out.printf("✅ Saved: %s (n=%d)\n", file.getName(), n);
            }

            System.out.println("\n📊 All results successfully written to results.csv!");
        } catch (IOException e) {
            System.err.println("❌ Error writing to CSV: " + e.getMessage());
        }
    }
}
