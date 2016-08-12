package labo3.dijkstra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Arnaud Comblin
 */
public class Vertex implements Iterable<Vertex> {

    private final HashMap<Vertex, Double> neighbors;
    public final Integer id;

    public Vertex(Integer id) {
        neighbors = new HashMap<>();
        this.id = id;
    }

    public boolean hasNeighbor(Vertex vertex) {
        return neighbors.containsKey(vertex);
    }

    public int size() {
        return neighbors.size();
    }

    @Override
    public Iterator<Vertex> iterator() {
        return neighbors.keySet().iterator();
    }

    public void addNeighbor(Vertex vertex, double weight) {
        if (vertex == null) {
            throw new IllegalArgumentException("Neighbor must not be null!");
        }
        if (equals(vertex)) {
            throw new IllegalArgumentException("Source and target must be different!");
        }
        if (hasNeighbor(vertex)) {
            throw new IllegalArgumentException("The edge already exists!");
        }
        if (weight < 0.0) {
            throw new IllegalArgumentException("The weight must be positive!");
        }
        neighbors.put(vertex, weight);
    }

    public double getWeightWith(Vertex vertex) {
        if (hasNeighbor(vertex)) {
            return neighbors.get(vertex);
        }
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        return Objects.equals(other.id, id);
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public String toStringWithNeighbors() {
        String str = toString();
        for (Vertex vertex : neighbors.keySet()) {
            str += "\n <-> " + vertex + " (w=" + neighbors.get(vertex) + ")";
        }
        return str;
    }
}
