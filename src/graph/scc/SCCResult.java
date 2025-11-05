package graph.scc;

import java.util.*;

public class SCCResult {
    private final List<List<String>> components = new ArrayList<>();

    // ✅ Добавляем пустой конструктор (чтобы new SCCResult() работал)
    public SCCResult() {}

    // ✅ Метод для добавления компоненты
    public void addComponent(List<String> component) {
        components.add(component);
    }

    // ✅ Метод для получения списка компонент (используется в Main.java)
    public List<List<String>> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
