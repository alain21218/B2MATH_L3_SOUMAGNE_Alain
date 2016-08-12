package labo3.dijkstra;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Arnaud Comblin
 */
public class Path implements Iterable<Vertex> {

    private final LinkedList<Vertex> vertices;
    private double length;

    public Path() {
        vertices = new LinkedList<Vertex>();
    }

    public Path(Path path) {
        vertices = (LinkedList<Vertex>) path.vertices.clone();
        length = path.length;
    }

    @Override
    public Iterator<Vertex> iterator() {
        return vertices.iterator();
    }

    public int count() {
        return vertices.size();
    }

    public double getLength() {
        return length;
    }

    public Vertex getSource() {
        return vertices.getFirst();
    }

    public Vertex getTarget() {
        return vertices.getLast();
    }

    public boolean contains(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public void addFirst(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex must not be null!");
        }
        if (vertices.isEmpty()) {
            vertices.addFirst(vertex);
        } else if (!vertex.hasNeighbor(vertices.getFirst())) {
            throw new IllegalArgumentException("The added vertex is not neighbor with the first vertex");
        } else {
            length += vertex.getWeightWith(vertices.getFirst());
            vertices.addFirst(vertex);
        }
    }

    public void add(Vertex vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex must not be null!");
        }
        if (vertices.isEmpty()) {
            vertices.add(vertex);
        } else if (!vertices.getLast().hasNeighbor(vertex)) {
            throw new IllegalArgumentException("The last vertex is not neighbor with the added vertex");
        } else {
            length += vertices.getLast().getWeightWith(vertex);
            vertices.add(vertex);
        }
    }

    @Override
    public String toString() {
        if (vertices.isEmpty()) {
            return "(empty)";
        }
        Iterator<Vertex> iterator = vertices.iterator();
        String str = "(" + iterator.next();
        while (iterator.hasNext()) {
            str += ", " + iterator.next();
        }
        return str + ")";
    }
}
