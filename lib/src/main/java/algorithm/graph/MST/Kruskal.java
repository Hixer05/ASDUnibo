package algorithm.graph.MST;

import datastructure.graph.*;
import datastructure.unionfind.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

/**
 * Generic graph computation of the Minimum Spanning Tree using the Kruskal algorithm
 * @param <D> type of the data object in the graph vertexes
 */
public class Kruskal<D> implements MST<D> {

	/**
	 * Computes a Minimum Spanning Tree of a passed graph using the Kruskal algorithm 
	 * and returns the computed spanning tree represented as a graph; Cost: O(m log n),
	 * where n and m are respectively the number of vertexes and edges in the graph
	 * @param graph the graph for which the Minimum Spanning Tree must be computed
	 * @return the graph representing the computed Minimum Spanning Tree
	 */	
	public Graph<D> MinimumSpanningTree(Graph<D> graph) {


		return null;
	}
	
	/**
	 * The comparator used for sorting the edges of the graph
	 */	
	private class CompEdge implements Comparator<Edge<D>> {
		public int compare(Edge<D> e1, Edge<D> e2) {
			if (e1.getWeight() > e2.getWeight())
				return 1; 
			else
				return -1;
		}
	}

}
