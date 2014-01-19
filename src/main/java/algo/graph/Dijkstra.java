package algo.graph;

import java.util.ArrayList;

import datastructures.graph.Node;
import datastructures.graph.NodeEdge;
import datastructures.graph.list.ListGraph;

public class Dijkstra {

	// Let v1 be the origin vertex,
	// and initialize W and ShortDist[u] as
	// W := {v1}
	// ShortDist[v1] :=0
	// FOR each u in V - {v1}
	// ShortDist[u] := T[v1,u]

	// Now repeatedly enlarge W
	// until W includes all verticies in V
	// WHILE W <> V

	// Find the vertex w in V - W at the minimum distance
	// from v1
	// MinDist := INFINITE
	// FOR each v in V - W
	// IF ShortDist[v] < MinDist
	// MinDist = ShortDist[v]
	// w := v
	// END {if}
	// END {for}

	// Add w to W
	// W := W U {w}

	// Update the shortest distance to vertices in V - W
	// FOR each u in V - W
	// ShortDist[u] := Min(ShorDist[u],ShortDist[w] + T[w,u])
	// END {while}
	//
	public void calculate(Integer startNodeId, Integer endNodeId, ListGraph graph) {
		Node n1 = graph.findNode(startNodeId);
		
		ArrayList<NodeEdge> paths = new ArrayList<NodeEdge>();
		paths.add(new NodeEdge(n1, 0.0));
	}
}
