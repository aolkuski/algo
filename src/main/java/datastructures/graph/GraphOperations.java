package datastructures.graph;

import java.util.ArrayList;

import exceptions.ElementDuplicationException;

/*
Dodaj wêze³
Usuñ wêze³
Dodaj krawêdŸ
Usuñ krawêdŸ
Podaj wêz³y s¹siednie do wêz³a
Podaj krawêdzie incydentne do wêz³a
ZnajdŸ wêze³
ZnajdŸ krawêdŸ
Podaj koñce krawêdzi
Podaj iloœæ wêz³ów
Podaj iloœæ krawêdzi
Czy wêz³y s¹ s¹siednie
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
