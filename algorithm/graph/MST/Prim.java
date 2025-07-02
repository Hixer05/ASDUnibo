package algorithm.graph.MST;

import datastructure.graph.*;
import datastructure.priorityqueue.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Generic graph computation of the Minimum Spanning Tree using the Prim algorithm
 * @param <D> type of the data object in the graph vertexes
 */	
public class Prim<D> implements MST<D> {
	
	/**
	 * Computes a Minimum Spanning Tree of a passed graph using the Prim algorithm 
	 * and returns the computed spanning tree represented as a graph; Cost: O(m log n),
	 * where n and m are respectively the number of vertexes and edges in the graph
	 * @param graph the graph for which the Minimum Spanning Tree must be computed
	 * @return the graph representing the computed Minimum Spanning Tree
	 */	
	public Graph<D> MinimumSpanningTree(Graph<D> graph) {
		// Auxiliary data structures
        Graph<D> g = new GraphAL<>();
        Map<Vertex<D>, Vertex<D>> newVert = new HashMap<>();
        DHeap<Double, Vertex<D>> pq = new DHeap<>();
        Map<Vertex<D>, PriorityQueueNode<Double, Vertex<D>>> pqnodes = new HashMap<>();
        Map<Vertex<D>, Boolean> bool = new HashMap<>();
        Map<Vertex<D>, Double> distance = new HashMap<>();
        Map<Vertex<D>, Vertex<D>> parent = new HashMap<>();

        ArrayList<Vertex<D>> vert = graph.vertexes();

        for (Vertex<D> v : vert) {
            newVert.put(v, g.addVertex(v.getData()));
            bool.put(v, false);
            distance.put(v, Double.POSITIVE_INFINITY);
        }

        Vertex<D> s = vert.get(0);
        pqnodes.put(s, pq.insert(0.0, s));

        while (!pq.isEmpty()) {
            Vertex<D> u = pq.findMin();
            pq.deleteMin();
            bool.put(u, true);

            if (!u.equals(s)) {
                g.addEdge(newVert.get(parent.get(u)), newVert.get(u), distance.get(u));
                g.addEdge(newVert.get(u), newVert.get(parent.get(u)), distance.get(u));
            }

            for (Edge<D> e : graph.outEdges(u)) {
                Vertex<D> v = e.getDest();
                if (distance.get(v) == Double.POSITIVE_INFINITY) {

                    distance.put(v, e.getWeight());
                    parent.put(v, u);
                    pqnodes.put(v, pq.insert(e.getWeight(), v));
                } else if (distance.get(v) > e.getWeight() && !bool.get(v)) {
                    distance.put(v, e.getWeight());
                    parent.put(v, u);
                    pq.decreaseKey(e.getWeight(), pqnodes.get(v));
                }
            }
        }
        return g;
    }
}
