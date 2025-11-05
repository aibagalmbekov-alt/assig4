package graph;

import java.util.*;

public class Graph {
    public Map<String, List<Edge>> adj = new HashMap<>();
    public boolean directed = true;

    public static class Edge {
        public String to;
        public int weight;

        public Edge(String to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public void addEdge(String from, String to, int w) {
        adj.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, w));
        if (!directed)
            adj.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(from, w));
    }

    public Set<String> getVertices() {
        return adj.keySet();
    }
    public void addVertex(String v) {
        if (!adj.containsKey(v)) {
            adj.put(v, new ArrayList<>());
        }
    }


    public List<Edge> getEdges(String v) {
        return adj.getOrDefault(v, new ArrayList<>());
    }
}
