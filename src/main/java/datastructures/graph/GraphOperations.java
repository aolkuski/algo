package datastructures.graph;

import java.util.ArrayList;

import exceptions.ElementDuplicationException;

/*
Dodaj w�ze�
Usu� w�ze�
Dodaj kraw�d�
Usu� kraw�d�
Podaj w�z�y s�siednie do w�z�a
Podaj kraw�dzie incydentne do w�z�a
Znajd� w�ze�
Znajd� kraw�d�
Podaj ko�ce kraw�dzi
Podaj ilo�� w�z��w
Podaj ilo�� kraw�dzi
Czy w�z�y s� s�siednie
*/

public interface GraphOperations {

	
	public boolean addNode(Node pNode) throws ElementDuplicationException ;
	public boolean removeNode(Integer nodeId);
	public boolean addEdge(Edge edge);
	public boolean removeEdge(Integer edgeId);
	public ArrayList<Node> getNeighbours(Integer nodeId);
	public ArrayList<Edge> getNodeEdges(Integer nodeId);
	public Node findNode(Integer nodeId);
	public Edge findEgde(Integer edgeId);
	public ArrayList<Node> getEdgeNodes(Integer edgeId);
	public Integer getEdgesCount();
	public Integer getNodesCount();
	public boolean areNodesNeighbours(Integer id1, Integer id2);
	
}
