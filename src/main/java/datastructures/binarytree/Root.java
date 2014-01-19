package datastructures.binarytree;

import java.io.Serializable;

public class Root extends Node implements Serializable{

	private static final long serialVersionUID = -4877187052672500486L;

	public Root(){
		super();
	};
	
	public Root(Character c, Integer freq) {
		super(c, freq);
	}
}
