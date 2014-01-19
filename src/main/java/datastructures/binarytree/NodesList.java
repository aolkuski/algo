package datastructures.binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class NodesList {

	private ArrayList<Node> list = new ArrayList<Node>();
	private ArrayList<Character> chars = new ArrayList<Character>();

	public ArrayList<Node> getList() {
		return list;
	}

	public void setList(ArrayList<Node> list) {
		this.list = list;
	}

	public void add(Node n) {
		this.getList().add(n);
	}
	
	public Node remove(Node n) {
		for(int i=0; i<list.size();i++){
			if(list.get(i) == n){
				return list.remove(i);
			}
		}
		return null;
	}
	
	public Node remove(int n) {
		return list.remove(n);
	}
	
	
	public void add(Character c){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getVal().equals(c)){
				list.get(i).incrementFreq();
				return;
			}
		}
		list.add(new NodeUnbound(c, 1));
	}

	public void sortAscending() {
		Collections.sort(list, new NodesComparator());
	}

	public ArrayList<Character> getChars() {
		return chars;
	}

	public void setChars() {
		for(Node n:list){
			chars.add(n.getVal());
		}
	}
	
	
	

}
