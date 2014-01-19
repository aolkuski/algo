package datastructures.binarytree;

import java.io.Serializable;

public abstract class Node implements Serializable{
	
	private static final long serialVersionUID = 3064569914069957991L;
	private Node parent;
	private Node child1;
	private Node child0;
	private Character val = null;
	private Integer frequency = null;
	private String id;
	
	public Node(){};
	
	public Node(Character c, Integer freq){
		this.val = c;
		this.frequency = freq;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Character getVal() {
		return val;
	}
	public void setVal(Character val) {
		this.val = val;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getChild1() {
		return child1;
	}
	public void setChild1(Node child1) {
		this.child1 = child1;
	}
	public Node getChild0() {
		return child0;
	}
	public void setChild0(Node child0) {
		this.child0 = child0;
	}
	
	public void incrementFreq(){
		this.frequency ++;
	}
	
	public boolean hasParent(){
		if (this.parent == null) return false;
		return true;
	}
	
	public boolean hasAnyChild(){
		return (hasChild0() || hasChild1());
	}
	
	public boolean hasChild0(){
		return !(child0 == null);
	}
	
	public boolean hasChild1(){
		return !(child1 == null);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
				
		sb.append(this.getClass().getSimpleName()+", val = '"+this.getVal()+"' frequency = "+this.getFrequency());
		if(this.getChild0() != null) sb.append(" child0 val: "+this.getChild0().getVal());		
		if(this.getChild1() != null) sb.append(" child1 val: "+this.getChild1().getVal());
		return sb.toString();
	}
	
	public String getParentId(){
		return this.getParent().getId();
	}
	
}
