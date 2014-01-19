package datastructures.graph;

public class NodeEdge {
	private Node node;
	private Double val;
	
	public NodeEdge(Node pNode, Double pVal){
		this.node = pNode;
		this.val = pVal;
	}
	
	public NodeEdge(Node pNode, Integer pVal){
		this.node = pNode;
		this.val = (pVal*1.0);
	}
	
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public Double getVal() {
		return val;
	}
	public void setVal(Double val) {
		this.val = val;
	}
	public void setVal(Integer val) {
		this.val = (val*1.0);
	}
	
	}
