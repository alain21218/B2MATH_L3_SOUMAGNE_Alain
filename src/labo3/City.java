package labo3;

import labo3.dijkstra.Vertex;

/**
 *
 * @author Arnaud Comblin
 */
public class City extends Vertex {

    public final String name;

    public City(Integer id, String name) {
        super(id);
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty!");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
