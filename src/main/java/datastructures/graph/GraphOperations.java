package datastructures.graph;

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

	
	public void addNode(Node pNode);
	public boolean removeNode(String nodeId);
	public boolean addEdge(String edgeId);
	public boolean removeEdge(String edgeId);
	public ArrayList<Node> getNeighbours(String nodeId);
	public ArrayList<Edge> getNodeEdges(String nodeId);
	public Node findNode(String nodeId);
	public Edge findEgde(String edgeId);
	public ArrayList<Node>  
}
