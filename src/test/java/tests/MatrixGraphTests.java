package tests;

import org.junit.Test;

import datastructures.graph.Edge;
import datastructures.graph.Node;
import datastructures.graph.matrix.MatrixGraph;
import exceptions.ElementDuplicationException;

public class MatrixGraphTests {

	
	@Test
	public void addEdgesNodesTest() throws ElementDuplicationException{
		MatrixGraph m = new MatrixGraph();
		m.addNode(new Node(2));
		m.addNode(new Node(3));
		m.addNode(new Node(4));
		m.addNode(new Node(5));
		m.addNode(new Node(8));
		m.addNode(new Node(10));
		
		m.addEdge(new Edge(1, 2, 3));
		m.addEdge(new Edge(2, 10, 8));
		m.addEdge(new Edge(3, 2, 10));

		m.printMatrix();
		m.removeNode(10);
		
		m.removeEdge(2);
		
		m.addNode(new Node(10));
		System.out.println("");
		m.printMatrix();
		m.addEdge(new Edge(2, 10, 8));
		System.out.println("");
		m.printMatrix();
		System.out.println(m);
	}
}
