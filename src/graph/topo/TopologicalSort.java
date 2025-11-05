package graph.topo;

import graph.Graph;
import java.util.*;

public class TopologicalSort {

    public static TopoResult sort(Graph g) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String v : g.getVertices()) {
            if (!visited.contains(v)) {
                dfs(v, g, visited, stack);
            }
        }

        List<String> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return new TopoResult(order);
    }

    private static void dfs(String v, Graph g, Set<String> visited, Stack<String> stack) {
        visited.add(v);
        for (Graph.Edge e : g.getEdges(v)) {
            if (!visited.contains(e.to)) {
                dfs(e.to, g, visited, stack);
            }
        }
        stack.push(v);
    }
}
