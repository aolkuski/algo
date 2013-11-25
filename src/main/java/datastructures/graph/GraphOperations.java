package datastructures.graph;

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
