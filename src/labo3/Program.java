/*
 * INFORMATIQUE DE GESTION - BAC2 - MATHEMATIQUES APPLIQUEES
 *
 * LABO 3 - Recherche du chemin le plus court
 */
package labo3;

import java.util.Iterator;

import labo3.dijkstra.*;

/**
 *
 * @author Arnaud Comblin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = generateGraph();
        System.out.println("Graph =\n" + g);

        PathFinder pathFinder = new PathFinder(g);
        Path shortestPath = pathFinder.getShortestPath(g.getVertex(1), g.getVertex(6));
        System.out.println("Shortest path = " + shortestPath + ", length = " + shortestPath.getLength() + " km");
        System.out.println("");

        Iterator<Vertex> pathIterator = shortestPath.iterator();
        Vertex previous, current;
        double distance = 0.0;
        current = pathIterator.next();
        System.out.println(current + " " + distance + " h");
        while (pathIterator.hasNext()) {
            previous = current;
            current = pathIterator.next();
            distance += previous.getWeightWith(current);
            System.out.println(current + " " + distance + " h");
        }
    }

    private static Graph generateGraph() {
        Graph graph = new Graph();

        graph.addVertex(new City(1, "A"));
        graph.addVertex(new City(2, "B"));
        graph.addVertex(new City(3, "C"));
        graph.addVertex(new City(4, "D"));
        graph.addVertex(new City(5, "E"));
        graph.addVertex(new City(6, "F"));

        graph.addWeightedEdge(1, 2, 1.0);
        graph.addWeightedEdge(1, 3, 3.0);
        graph.addWeightedEdge(1, 5, 3.0);
        graph.addWeightedEdge(2, 1, 1.0);
        graph.addWeightedEdge(2, 3, 3.0);
        graph.addWeightedEdge(2, 4, 5.0);
        graph.addWeightedEdge(2, 5, 1.0);
        graph.addWeightedEdge(3, 1, 3.0);
        graph.addWeightedEdge(3, 2, 3.0);
        graph.addWeightedEdge(3, 4, 1.0);
        graph.addWeightedEdge(3, 6, 3.0);
        graph.addWeightedEdge(4, 2, 5.0);
        graph.addWeightedEdge(4, 3, 1.0);
        graph.addWeightedEdge(4, 6, 1.0);
        graph.addWeightedEdge(5, 1, 3.0);
        graph.addWeightedEdge(5, 2, 1.0);
        graph.addWeightedEdge(6, 3, 3.0);
        graph.addWeightedEdge(6, 4, 1.0);

        return graph;
    }
}
