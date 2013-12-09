package datastructures.graph;

public class Edge extends AbstractEdge{

	private Integer id;
	private Integer startNodeId;
	private Integer endNodeId;
	private String stringValue;
	private Integer integerValue;
	
	public Edge(Integer pId, Integer pStartNodeId, Integer pEndNodeId){
		this.id = pId;
		this.startNodeId = pStartNodeId;
		this.endNodeId = pEndNodeId;
	}
	
	public Edge(Integer pId, Node pStartNode, Node pEndNode){
		this.id = pId;
		this.startNodeId = pStartNode.getId();
		this.endNodeId = pEndNode.getId();
	}
	
	
	
	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Integer getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(Integer integerValue) {
		this.integerValue = integerValue;
	}

	public Integer getId(){
		return this.id;
	}

	public Integer getStartNodeId() {
		return startNodeId;
	}

	public void setStartNodeId(Integer startNodeId) {
		this.startNodeId = startNodeId;
	}

	public Integer getEndNodeId() {
		return endNodeId;
	}

	public void setEndNodeId(Integer endNodeId) {
		this.endNodeId = endNodeId;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "Edge id = "+id+" with starting node id = "+this.getStartNodeId()+" and end node id = "+endNodeId; 
	}
	
	
	
}
