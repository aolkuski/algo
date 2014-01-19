package tests;

import org.junit.Test;

import datastructures.graph.Edge;
import datastructures.graph.Node;
import datastructures.graph.list.ListGraph;
import exceptions.ElementDuplicationException;

public class ListGraphTest {

	@Test
	public void test() throws ElementDuplicationException{
		ListGraph m = new ListGraph();
		m.addNode(new Node(2));
		m.addNode(new Node(3));
		m.addNode(new Node(4));
		m.addNode(new Node(5));
		m.addNode(new Node(8));
		m.addNode(new Node(10));
		
		m.addEdge(new Edge(1, 2, 3));
		m.addEdge(new Edge(2, 10, 8));
		m.addEdge(new Edge(3, 2, 10));
		m.addEdge(new Edge(2, 4,5));

		m.printGraph();
		m.removeNode(10);
		
		m.removeEdge(2);
		
		m.addNode(new Node(10));
		System.out.println("");
		m.printGraph();
		m.addEdge(new Edge(2, 10, 8));
		System.out.println("");
		m.printGraph();
		System.out.println(m);
	}
}
