package algorithm.graph.traversal;

import datastructure.graph.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementation of the BFS traversal for graphs containing generic data. Returns an ArrayList of VisitedVertex<D>
 * @param <D> type of the data object in the graph vertexes
 */
public class BFS<D> implements Traversal<D> {
	
	/**
   	 * Constructs a BFS object exposing the visit method
	 */	
	public BFS() {
		// empty on purpose because there is nothing to initialize
	}
	
	/**
	 * Performs a visit of a passed graph and returns tha ArrayList with the visited vertexes
	 * created as objects of type VisitedVertexBFS<D>
	 * @param graph the graph to visit
	 * @param source the initial source vertex (irrelevant in case of DFS)
	 * @return the ArrayList with the visited vertexes
	 */	
	public ArrayList<VisitedVertex<D>> visit(Graph<D> graph, Vertex<D> source) {
		HashMap<Vertex<D>, Boolean> visited = new HashMap<Vertex<D>, Boolean>();
		ArrayList<VisitedVertex<D>> l = new ArrayList<VisitedVertex<D>>();
		ArrayDeque<Vertex<D>> q = new ArrayDeque<Vertex<D>>();

		ArrayList<Vertex<D>> verts = graph.vertexes();
		for( Vertex<D> v : verts )
			visited.put(v,false);
		visited.put(source,true);
		l.add(new VisitedVertexBFS<D>(source, null));
		q.add(source);
		while(!q.isEmpty()){
			Vertex<D> u = q.remove();
			for(Edge<D> e : graph.outEdges(u)){
				Vertex<D> v = e.getDest();
				if(!visited.get(v)){
					visited.put(v,true);
					l.add(new VisitedVertexBFS<D>(v,u));
					q.add(v);
				}
			}
		}
		return l;
	}
		
}
