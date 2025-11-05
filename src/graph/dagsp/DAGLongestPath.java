package graph.dagsp;

import graph.Graph;
import graph.topo.TopologicalSort;
import graph.topo.TopoResult;
import java.util.*;

public class DAGLongestPath {

    public static PathResult find(Graph g, String source) {
        long start = System.nanoTime();

        // Собираем все вершины (включая те, что встречаются только как 'to')
        Set<String> vertices = new HashSet<>(g.getVertices());
        for (String u : g.getVertices()) {
            for (Graph.Edge e : g.getEdges(u)) {
                vertices.add(e.to);
            }
        }

        // Инициализация расстояний (начальное значение = -∞)
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        for (String v : vertices) {
            dist.put(v, Integer.MIN_VALUE);
            prev.put(v, null);
        }
        dist.put(source, 0);

        // Получаем топологический порядок
        List<String> order = TopologicalSort.sort(g).getOrder();

        // Основной цикл (релаксация рёбер)
        for (String u : order) {
            if (dist.get(u) == Integer.MIN_VALUE) continue;
            for (Graph.Edge e : g.getEdges(u)) {
                String v = e.to;
                int w = e.weight;

                int newDist = dist.get(u) + w;
                if (newDist > dist.get(v)) {
                    dist.put(v, newDist);
                    prev.put(v, u);
                }
            }
        }

        long end = System.nanoTime();
        double timeMs = (end - start) / 1e6;

        System.out.println("🏁 DAG Longest Path done in " + timeMs + " ms");

        // ✅ теперь добавляем 3-й параметр (время)
        return new PathResult(dist, prev, timeMs);
    }
}
