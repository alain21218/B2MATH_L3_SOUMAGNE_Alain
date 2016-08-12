package labo3.dijkstra;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Arnaud Comblin
 */
public class Graph implements Iterable<Vertex> {

    private final HashMap<Integer, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public boolean hasVertex(Integer id) {
        return vertices.containsKey(id);
    }

    public int getOrder() {
        return vertices.size();
    }

    @Override
    public Iterator<Vertex> iterator() {
        return vertices.values().iterator();
    }

    public Vertex getVertex(Integer id) {
        return vertices.get(id);
    }

    public void addVertex(Vertex vertex) {
        if (vertex != null && !hasVertex(vertex.id)) {
            vertices.put(vertex.id, vertex);
        }
    }

    public void addEdge(Integer id1, Integer id2) {
        addWeightedEdge(id1, id2, 1.0);
    }

    public void addWeightedEdge(Integer id1, Integer id2, double weight) {
        if (id1 != null && id2 != null && hasVertex(id1) && hasVertex(id2)) {
            getVertex(id1).addNeighbor(getVertex(id2), weight);
        }
    }

    @Override
    public String toString() {
        if (vertices.isEmpty()) {
            return "(empty)";
        }
        String str = "";
        for (Integer id : vertices.keySet()) {
            str += vertices.get(id).toStringWithNeighbors() + "\n";
        }
        return str;
    }
}
