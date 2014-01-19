package datastructures.graph;

import java.util.ArrayList;

import exceptions.ElementDuplicationException;

public class Node {
	private Integer id;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private ArrayList<NodeEdge> neighbours = new ArrayList<NodeEdge>();
	

	public ArrayList<NodeEdge> getNeighbours() {
		return neighbours;
	}
	
	public void addNeighbour(Node pNode, Integer pVal) throws ElementDuplicationException{
		addNeighbour(pNode, pVal*1.0);
	}
	
	public void addNeighbour(Node pNode, Double pVal) throws ElementDuplicationException{
		for(NodeEdge ne : neighbours){
			if(ne.getNode().getId() == pNode.getId() && ne.getVal() == pVal){
				throw new ElementDuplicationException("Node id="+pNode.getId()+" is already a neighbour of node id="+this.id);
			}
		}
		neighbours.add(new NodeEdge(pNode, pVal));
	}

	public void removeEdge(Integer edgeId) {
		int i = 0;
		boolean flag = false;
		for (i = 0; i < edges.size(); i++) {
			if (edges.get(i).getId().equals(edgeId)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			edges.remove(i);
		}
	}

	public Node(Integer pId) {
		this.id = pId;
	}

	public Integer getId() {
		return this.id;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Edge e) {
		this.edges.add(e);
	}

	@Override
	public boolean equals(Object o) {
		return (this.id.equals(((Node) o).getId()));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Node id = " + id + " with ");
		if (edges.size() == 0) {
			sb.append("no edges.");
		} else {
			sb.append("edges: ");
		}
		for (Edge e : edges) {
			sb.append(e.getId() + ", ");
		}
		sb.append(".");

		return sb.toString();
	}
}
