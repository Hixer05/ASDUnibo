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
        GraphAL<D> g = new GraphAL<>();
        HashMap<Vertex<D>, Vertex<D>> newVert = new HashMap<Vertex<D>, Vertex<D>>();
        QuickUnionRank<D> uf = new QuickUnionRank<D>();
        HashMap<Vertex<D>, UnionFindNode<D>> ufnodes = new HashMap<Vertex<D>, UnionFindNode<D>>();

        for (Vertex<D> v : graph.vertexes()) {
            newVert.put(v, g.addVertex(v.getData()));
            ufnodes.put(v, uf.makeSet(v.getData()));
        }


        ArrayList<Edge<D>> e = graph.edges();
        e.sort(new CompEdge());
// a b c d e f g h i
// 0 1 2 3 4 5 6 7 8 9
        for (Edge<D> edge : e) {
            Vertex<D> u = edge.getSource();
            Vertex<D> v = edge.getDest();
            double w = edge.getWeight();

            UnionFindNode<D> ru = uf.find(ufnodes.get(u));
            UnionFindNode<D> rv = uf.find(ufnodes.get(v));

            if (ru != rv) {
                uf.union(ru, rv);
                g.addEdge(newVert.get(u), newVert.get(v), w);
                g.addEdge(newVert.get(v), newVert.get(u), w);
            }
        }

        return g;
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
