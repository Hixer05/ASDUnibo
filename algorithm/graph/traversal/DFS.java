package algorithm.graph.traversal;

import datastructure.graph.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementation of the DFS traversal for graphs containing generic data. Returns an ArrayList of VisitedVertex<D>
 * @param <D> type of the data object in the graph vertexes
 */
public class DFS<D> implements Traversal<D> {
	
	private int time;
	private ArrayList<VisitedVertex<D>> l;
	private Map<Vertex<D>, Boolean> visited;
		
	/**
   	 * Constructs a DFS object exposing the visit method
	 */	
	public DFS() {
		// empty on purpose because there is nothing to initialize
	}
		
	/**
	 * Performs a visit of a passed graph and returns tha ArrayList with the visited vertexes
	 * created as objects of type VisitedVertexDFS<D>
	 * @param graph the graph to visit
	 * @param source the initial source vertex (irrelevant in case of DFS)
	 * @return the ArrayList with the visited vertexes
	 */	
	public ArrayList<VisitedVertex<D>> visit(Graph<D> graph, Vertex<D> source) {
		time = 0;
		l = new ArrayList<VisitedVertex<D>>();
		visited = new HashMap<Vertex<D>,Boolean>();

		ArrayList<Vertex<D>> vert = graph.vertexes();

		for (Vertex<D> v : vert)
			visited.put(v,false);

		for (Vertex<D> u : vert)
			if (!visited.get(u))
				DFSvisit(graph, new VisitedVertexDFS<D>(u,null));

		return l;
	}

	/**
	 * Auxiliary function used in the recursive implementation of the DFS visit
	 */
	private void DFSvisit(Graph<D> g, VisitedVertexDFS<D> v) {
		visited.put(v.getVertex(), true);
		l.add(v);
		time++;
		v.dt = time;

		for(Edge<D> e : g.outEdges(v.getVertex())){
			Vertex<D> w = e.getDest();
			if(!visited.get(w))
				DFSvisit(g, new VisitedVertexDFS<D>(w,v.getVertex()));
		}

		time++;
		v.ft = time;
	}


		
}
