package datastructures.binarytree;

import java.util.Comparator;

public class NodesComparator implements Comparator<Node>{

	public int compare(Node o1, Node o2) {
		
		if(o1.getFrequency() - o2.getFrequency() < 0){
			return -1;
		}
		if(o1.getFrequency() - o2.getFrequency() > 0){
			return 1;
		}
		return 0;
	}

}
