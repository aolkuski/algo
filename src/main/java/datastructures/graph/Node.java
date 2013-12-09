package datastructures.graph;

import java.util.ArrayList;

public class Node {
	private Integer id;
	private ArrayList<Edge> edges = new ArrayList<Edge>();

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
