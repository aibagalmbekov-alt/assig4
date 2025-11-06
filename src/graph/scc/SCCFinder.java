package graph.scc;

import graph.Graph;
import java.util.*;

public class SCCFinder {

    public static SCCResult findSCC(Graph g) {
        SCCResult res = new SCCResult(); //

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        // === Step 1: Order by finish time (DFS) ===
        for (String v : g.getVertices()) {
            if (!visited.contains(v))
                dfs1(v, g, visited, stack);
        }

        // === Step 2: Transpose the graph ===
        Graph gt = transpose(g);

        // === Step 3: Process vertices in decreasing finish time ===
        visited.clear();
        while (!stack.isEmpty()) {
            String v = stack.pop();
            if (!visited.contains(v)) {
                List<String> component = new ArrayList<>();
                dfs2(v, gt, visited, component);
                res.addComponent(component);
            }
        }

        return res;
    }

    // --- DFS for first pass ---
    private static void dfs1(String v, Graph g, Set<String> visited, Stack<String> stack) {
        visited.add(v);
        for (Graph.Edge e : g.getEdges(v)) {
            if (!visited.contains(e.to))
                dfs1(e.to, g, visited, stack);
        }
        stack.push(v);
    }

    // --- DFS for second pass ---
    private static void dfs2(String v, Graph g, Set<String> visited, List<String> component) {
        visited.add(v);
        component.add(v);
        for (Graph.Edge e : g.getEdges(v)) {
            if (!visited.contains(e.to))
                dfs2(e.to, g, visited, component);
        }
    }

    // --- Build transposed graph ---
    private static Graph transpose(Graph g) {
        Graph gt = new Graph();
        for (String v : g.getVertices()) {
            for (Graph.Edge e : g.getEdges(v)) {
                gt.addEdge(e.to, v, e.weight); // инвертируем направление
            }
        }
        return gt;
    }
}
