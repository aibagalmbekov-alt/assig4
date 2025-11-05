package graph.topo;
import java.util.*;

public class TopoResult {
    public List<String> order;

    public TopoResult(List<String> order) {
        this.order = order;
    }

    public List<String> getOrder() {
        return order;
    }
}
