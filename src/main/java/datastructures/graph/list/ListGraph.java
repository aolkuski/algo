package datastructures.graph.list;

import java.util.ArrayList;

import datastructures.graph.Edge;
import datastructures.graph.GraphOperations;
import datastructures.graph.Node;
import datastructures.graph.NodeEdge;
import exceptions.ElementDuplicationException;

/**
 * Lista sasiedztw. Przechowujemy wszystko na listach. Kazzdy wierzcholek ma w
 * sobie liste swoich sasiadow, a kazda krawedz ma liste graniczacych z nia
 * wierzcholkow.
 * 
 * @author aolkuski 08:06:27 09-12-2013
 * 
 */

public class ListGraph implements GraphOperations {

	protected ArrayList<Node> nodeArrayList = new ArrayList<Node>();

	public boolean addNode(Node pNode) throws ElementDuplicationException {
		if (canNodeBeAdded(pNode)) {
			nodeArrayList.add(pNode);
			return true;
		}
		return false;
	}

	private boolean canNodeBeAdded(Node pNode) {
		Integer nodeId = pNode.getId();
		for (Node n : nodeArrayList) {
			if (n.getId() == nodeId) {
				return false;
			}
		}
		if (pNode.getNeighbours().size() > 0) {
			for (NodeEdge ne : pNode.getNeighbours()) {
				if (!isNodePresent(ne.getNode().getId())) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isNodePresent(Integer id) {
		for (Node n : nodeArrayList) {
			if (n.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean removeNode(Integer nodeId) {
		for (Node n : nodeArrayList) {
			// dla kazdego Node'a
			if (n.getId() == nodeId) {
				// za wyjatkiem tego, ktory chcemy usunac
				continue;
			}
			// wez jego liste sasiadow i usun tego sasiada
			for (int i = 0; i < n.getNeighbours().size(); i++) {
				if (n.getNeighbours().get(i).getNode().getId() == nodeId) {
					n.getNeighbours().remove(i);
				}
			}
		}
		// na koniec usun samego node'a
		for (int i = 0; i < nodeArrayList.size(); i++) {
			if (nodeArrayList.get(i).getId() == nodeId) {
				System.out.println("node with id "+nodeId+" was removed.");
				nodeArrayList.remove(i);
			}
		}
		return true;
	}

	public boolean addEdge(Edge edge) {

		if (isNodePresent(edge.getStartNodeId()) && isNodePresent(edge.getEndNodeId())) {
			Node n1 = findNode(edge.getStartNodeId());
			Node n2 = findNode(edge.getEndNodeId());
			try {
				n1.addNeighbour(n2, edge.getDoubleValue());
			} catch (ElementDuplicationException e) {
				System.out.println("Edge duplication.");
				return false;
			}
			return true;
		}
		return false;
	}

	public boolean removeEdge(Integer edgeId) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Node> getNeighbours(Integer nodeId) {
		Node n = findNode(nodeId);
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (NodeEdge ne : n.getNeighbours()) {
			nodes.add(ne.getNode());
		}
		return nodes;
	}

	public ArrayList<Edge> getNodeEdges(Integer nodeId) {
		Node n = findNode(nodeId);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (NodeEdge ne : n.getNeighbours()) {
			edges.add(new Edge(n.getId(), ne.getNode().getId(), ne.getVal()));
		}
		return edges;
	}

	public Node findNode(Integer nodeId) {
		for (Node n : nodeArrayList) {
			if (n.getId() == nodeId) {
				return n;
			}
		}
		return null;
	}

	public Edge findEgde(Integer edgeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Node> getEdgeNodes(Integer edgeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getEdgesCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getNodesCount() {
		return nodeArrayList.size();
	}

	public boolean areNodesNeighbours(Integer startNodeId, Integer endNodeId) {
		 Node n = findNode(startNodeId);
		 ArrayList<NodeEdge> neighbs = n.getNeighbours();
		 for(NodeEdge ne:neighbs){
			 if(endNodeId.equals(ne.getNode().getId())) {
				 return true;
			 }
		 }
		return false;
	}

	public void printGraph() {
		System.out.println("Nodes and their neighbours");
		StringBuilder sb = new StringBuilder();
		for (Node n : nodeArrayList) {
			sb.append("Node id: " + n.getId());
			if (n.getNeighbours().size() > 0) {
				sb.append(" has neighbours: ");
				for (NodeEdge ne : n.getNeighbours()) {
					sb.append(ne.getNode().getId()+"("+ne.getVal()+"), ");
				}
				sb.setCharAt(sb.length() - 2, '.');
			} else {
				sb.append(" has no neighbours.");
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}

}
