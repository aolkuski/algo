package tests;

import java.io.IOException;

import org.junit.Test;

import datastructures.graph.list.ListGraph;

import algo.graph.GraphCreator;
import exceptions.ElementDuplicationException;

public class DijkstraTest {

	
	@Test
	public void test() throws IOException, NumberFormatException, ElementDuplicationException{
		ListGraph graph = GraphCreator.getGraph("graph.txt");
		
		
	}
}
