package labo3.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Arnaud Comblin
 */
public class PathFinder {

    private Graph graph;	

    public PathFinder(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph must no be null!");
        }

        this.graph = graph;
    }
    
    public Path getShortestPath(Vertex source, Vertex target) {
    	/*
    	 * Exercice 4a
    	 */
    	
        return null;
    }

    private Vertex nearestUnvisitedVertex(LinkedList<Vertex> unvisited, HashMap<Vertex, Double> distances) {
    	/*
    	 * Exercice 4a
    	 */
    	
        return null;
    }
}
