package algo.graph;

import helpers.Reader;

import java.io.IOException;
import java.util.ArrayList;

import datastructures.graph.Edge;
import datastructures.graph.Node;
import datastructures.graph.list.ListGraph;
import exceptions.ElementDuplicationException;

public class GraphCreator {

	public static ListGraph getGraph(String fileName) throws IOException, NumberFormatException, ElementDuplicationException{
		Reader r = new Reader(fileName);
		ArrayList<ArrayList<String>> allNodes = r.getFilesAsListOfStringArrays("\\s+");
		
		ListGraph graph = new ListGraph();
		
		for(ArrayList<String> n : allNodes){
			Node newNode = new Node(Integer.valueOf(n.get(0)));
			graph.addNode(newNode);
		}
		
		for(ArrayList<String> n : allNodes){
			Edge e = new Edge(Integer.valueOf(n.get(0)), Integer.valueOf(n.get(1)), Double.valueOf(n.get(2)));
			graph.addEdge(e);
		}
		
		return graph;
		
	}
}
