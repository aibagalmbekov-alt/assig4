package graph;

import com.google.gson.*;
import java.io.FileReader;

public class GraphUtils {
    public static Graph loadFromJson(String filename) {
        Graph g = new Graph();
        try {
            JsonObject json = JsonParser.parseReader(new FileReader(filename)).getAsJsonObject();

            // Считываем список вершин (если есть)
            if (json.has("nodes")) {
                JsonArray nodes = json.getAsJsonArray("nodes");
                for (JsonElement n : nodes) {
                    g.addVertex(n.getAsString());
                }
            }

            // Считываем рёбра
            JsonArray edges = json.getAsJsonArray("edges");
            for (JsonElement e : edges) {
                JsonObject edge = e.getAsJsonObject();
                String from = edge.get("from").getAsString();
                String to = edge.get("to").getAsString();
                int weight;

                // Обрабатываем разные возможные ключи: w, weight, value, cost
                if (edge.has("w")) {
                    weight = edge.get("w").getAsInt();
                } else if (edge.has("weight")) {
                    weight = edge.get("weight").getAsInt();
                } else if (edge.has("cost")) {
                    weight = edge.get("cost").getAsInt();
                } else {
                    weight = 1; // по умолчанию, если вес не указан
                }

                g.addEdge(from, to, weight);
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to load " + filename + ": " + e.getMessage());
        }
        return g;
    }
}
