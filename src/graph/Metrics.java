package graph;

import java.io.FileWriter;
import java.io.IOException;

public class Metrics {

    public static void saveToCSV(String filename, int n, double sccTime, double topoTime, double shortTime, double longTime) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            // Если файл пуст — добавляем заголовок
            java.io.File file = new java.io.File(filename);
            if (file.length() == 0) {
                writer.write("n,scc_ms,topo_ms,short_ms,long_ms\n");
            }

            // Записываем строку с результатами
            writer.write(n + "," + sccTime + "," + topoTime + "," + shortTime + "," + longTime + "\n");

            System.out.println("📊 Results saved to " + filename);
        } catch (IOException e) {
            System.err.println("❌ Error writing CSV: " + e.getMessage());
        }
    }
}
