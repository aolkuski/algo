package datastructures.graph.matrix;

import java.util.ArrayList;

import datastructures.graph.AbstractEdge;
import datastructures.graph.Edge;
import datastructures.graph.GraphOperations;
import datastructures.graph.Node;
import datastructures.graph.NullEdge;
import exceptions.ElementDuplicationException;

/**
 * Koncepcja: Mamy macierz krawedzi. Jesli w danej komorce o wspolrzednych x,y
 * znajduje sie krawedz, znaczy, ze jest to krawedz skierowana z wezla o id x do
 * wezla o id y. Wierzcholki sa przechowywwane w osobnej strukturze w postaci
 * tablicy. Dodanie wierzcholka powoduje realokacje macierzy, jesli jego id jest
 * wieksze od obecnej wielkosci macierzy. Dzieki temu dodawanie krawedzi jest
 * mozliwe tylko wtedy, kiedy krawedz jest zaczepiona w konkretnych dwoch
 * wierzcholkach. Krawedzie w macierzy sa skierowane. W przypadku koniecznosci
 * dodania krawedzi nieskierowanej, nalezy dodac ja w punkcie x,y oraz y,x.
 * 
 * 
 * @author aolkuski 07:47:39 02-12-2013
 * 
 */
public class MatrixGraph implements GraphOperations {

	protected AbstractEdge[][] edgeMatrix = new AbstractEdge[1][1];
	protected ArrayList<Node> nodeArrayList = new ArrayList<Node>();
	protected ArrayList<Edge> edgeArrayList = new ArrayList<Edge>();

	public boolean addNode(Node pNode) throws ElementDuplicationException {
		reallocMatrixIfNecessary(pNode.getId());
		if (!isNodePresent(pNode)) {
			this.nodeArrayList.add(pNode);
			
		} else {
			throw new ElementDuplicationException(
					"Element of this ID already present in Graph.");
		}
		return false;
	}

	/**
	 * czy istnieja wezly do ktorych krawedz ma byc dopieta
	 */
	private boolean canEdgeBeInserted(Edge e) {
		if (isNodePresent(new Node(e.getEndNodeId()))
				&& isNodePresent(new Node(e.getStartNodeId()))) {
			return true;
		}
		return false;
	}

	/**
	 * znajdz node'a wsrod dodanych na podstawie jego id
	 */
	public Node findNode(Integer nodeId) {
		Node found = null;

		for (Node n : nodeArrayList) {
			if (n.getId().equals(nodeId)) {
				found = n;
			}
		}

		return found;
	}

	/**
	 * czy node jest dodany do grupy node'ow
	 */
	private boolean isNodePresent(Node pNode) {
		if (!(findNode(pNode.getId()) == null)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * komorka w macierzy reprezentuje miejsce, gdzie krawedz ma byc wstawiona.
	 * Jesli ma byc dodany node, ktorego wspolrzedne sa poza obecna macierza, to
	 * jest ona realokowana.
	 */
	private void reallocMatrixIfNecessary(Integer size) {
		AbstractEdge[][] edgeMatrixTmp = new AbstractEdge[size + 1][size + 1];

		for (int i = 0; i < size+1; i++) {
			for (int j = 0; j < size+1; j++) {
				if ((i < edgeMatrix.length) && (j < edgeMatrix.length) && (edgeMatrix[i][j] != null )){
					edgeMatrixTmp[i][j] = edgeMatrix[i][j];
				} else {
					edgeMatrixTmp[i][j] = new NullEdge();
				}
			}
		}
		this.edgeMatrix = edgeMatrixTmp;
	}

	public boolean removeNode(Integer nodeId) {
		if (isNodePresent(new Node(nodeId))) {
			Node n = findNode(nodeId);
			int ctr = n.getEdges().size();
			for (int i = 0; i < ctr; i++) {
				Edge e = n.getEdges().get(i);
				if (e.getEndNodeId() != nodeId) {
					Node n1 = findNode(e.getEndNodeId());
					n1.getEdges().remove(e);
				}
				if (e.getStartNodeId() != nodeId) {
					Node n1 = findNode(e.getStartNodeId());
					n1.getEdges().remove(e);
				}
				ctr = n.getEdges().size();
			}
			for (int i = 0; i < this.edgeMatrix.length; i++) {
				edgeMatrix[i][nodeId] = new NullEdge();
				edgeMatrix[nodeId][i] = new NullEdge();
			}
			for (int i = 0; i < this.nodeArrayList.size(); i++) {
				if (nodeArrayList.get(i).getId() == nodeId) {
					nodeArrayList.remove(i);
					break;
				}
			}

		}
		return false;
	}

	public boolean addEdge(Edge edge) {

		if (!canEdgeBeInserted(edge)) {
			System.out.println("Can't be insterted!");
			return false;
		}
		Node n = findNode(edge.getStartNodeId());
		n.addEdge(edge);
		n = findNode(edge.getEndNodeId());
		n.addEdge(edge);
		edgeMatrix[edge.getStartNodeId()][edge.getEndNodeId()] = edge;
		edgeArrayList.add(edge);

		return true;
	}

	public boolean removeEdge(Integer edgeId) {
		for (Node n : nodeArrayList) {
			n.removeEdge(edgeId);
		}
		for (int i = 0; i < edgeArrayList.size(); i++) {
			if (edgeArrayList.get(i).getId() == edgeId) {
				edgeMatrix[edgeArrayList.get(i).getStartNodeId()][edgeArrayList.get(i).getEndNodeId()] = new NullEdge();
				edgeArrayList.remove(i);
			}
		}

		return false;
	}

	public ArrayList<Node> getNeighbours(Integer nodeId) {
		ArrayList<Node> neighbours = new ArrayList<Node>();
		for(int i=0;i<edgeMatrix.length;i++){
			if(edgeMatrix[i][nodeId] instanceof Edge){
				Edge e = (Edge) edgeMatrix[i][nodeId];
				if(e.getEndNodeId() == e.getStartNodeId() && (e.getEndNodeId() == nodeId)){
					neighbours.add(findNode(nodeId));
				} else {
					if(nodeId == e.getEndNodeId()){
						neighbours.add(findNode(e.getStartNodeId()));
					} else {
						neighbours.add(findNode(e.getEndNodeId()));
					}
					
				}
			}
			if(edgeMatrix[nodeId][i] instanceof Edge){
				Edge e = (Edge) edgeMatrix[i][nodeId];
				if(e.getEndNodeId() == e.getStartNodeId() && (e.getEndNodeId() == nodeId)){
					neighbours.add(findNode(nodeId));
				} else {
					if(nodeId == e.getEndNodeId()){
						neighbours.add(findNode(e.getStartNodeId()));
					} else {
						neighbours.add(findNode(e.getEndNodeId()));
					}
					
				}
			}
		}
		return neighbours;
	}

	public ArrayList<Edge> getNodeEdges(Integer nodeId) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0;i<edgeMatrix.length;i++){
			Edge e1 = (Edge) edgeMatrix[i][nodeId];
			Edge e2 = (Edge) edgeMatrix[nodeId][i];
			if(i==nodeId && (edgeMatrix[i][i] instanceof Edge)){
				edges.add(e1);
				continue;
			}
			if(e1 instanceof Edge){
				edges.add(e1);
			}
			if(e2 instanceof Edge){
				edges.add(e2);
			}
		}
		return null;
	}

	public Edge findEgde(Integer edgeId) {
		Edge e = null;
		for (int i = 0; i < edgeArrayList.size(); i++) {
			if (edgeArrayList.get(i).getId() == edgeId) {
				e = edgeArrayList.get(i);
			}
		}
		return e;
	}

	public ArrayList<Node> getEdgeNodes(Integer edgeId) {
		ArrayList<Node> nodes = new ArrayList<Node>();
//		Set<Node> nodesSet = new Set<Node>();
		for(int i=0;i<edgeMatrix.length;i++){
			for(int j=0;j<edgeMatrix.length;j++){
				Edge e = (Edge)edgeMatrix[i][j];
				if(e.getId() == edgeId){
					nodes.add(findNode(e.getStartNodeId()));
					nodes.add(findNode(e.getEndNodeId()));
				}
			}
		}
		return null;
	}

	public Integer getEdgesCount() {
		return edgeArrayList.size();
	}

	public Integer getNodesCount() {
		return nodeArrayList.size();
	}

	public boolean areNodesNeighbours(Integer id1, Integer id2) {
		if((edgeMatrix[id1][id2] instanceof Edge) || (edgeMatrix[id2][id1] instanceof Edge)){
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph consists of: \nNodes:\n");
		for (Node n : nodeArrayList) {
			sb.append(n + "\n");
		}
		sb.append("... and edges: \n");
		System.out.println(edgeMatrix.length);
		for (int i = 0; i < edgeMatrix.length; i++) {
			for (int j = 0; j < edgeMatrix[i].length; j++) {
				if ((edgeMatrix[i][j] != null)
						&& ((edgeMatrix[i][j] instanceof Edge))) {
					sb.append((Edge) edgeMatrix[i][j] + "\n");
				}
			}
		}
		return sb.toString();

	}

	public void printGraph() {
		for (int i = 0; i < this.edgeMatrix.length; i++) {
			for (int j = 0; j < this.edgeMatrix.length; j++) {
				if (edgeMatrix[i][j] instanceof NullEdge) {
					System.out.print("  -  ");
				} else if (edgeMatrix[i][j] != null){
					System.out.print("  "+((Edge)edgeMatrix[i][j]).getId() + "  ");
				}
			}
			System.out.println("\n");
		}

	}

}
