package graph.dagsp;

import java.util.*;

public class PathResult {
    // --- Делаем поля public ---
    public Map<String, Integer> distances = new HashMap<>();
    public Map<String, String> previous = new HashMap<>();
    private double executionTimeMs;

    public PathResult(Map<String, Integer> distances, Map<String, String> previous, double executionTimeMs) {
        this.distances = distances;
        this.previous = previous;
        this.executionTimeMs = executionTimeMs;
    }

    public double getExecutionTimeMs() {
        return executionTimeMs;
    }

    // ✅ Метод для построения пути (чтобы .getPath() работал)
    public List<String> getPath(String target) {
        List<String> path = new ArrayList<>();
        String current = target;
        while (current != null && previous.containsKey(current)) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    @Override
    public String toString() {
        return "Distances: " + distances + ", Time: " + executionTimeMs + " ms";
    }
}
