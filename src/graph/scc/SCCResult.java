package graph.scc;

import java.util.*;

public class SCCResult {
    private final List<List<String>> components = new ArrayList<>();

     public SCCResult() {}


    public void addComponent(List<String> component) {
        components.add(component);
    }


    public List<List<String>> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
