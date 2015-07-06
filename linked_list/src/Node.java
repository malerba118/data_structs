
public class Node {


	@Override
	public boolean equals(Object obj) {
		if (!obj.getClass().equals(this.getClass())) return false;
		Node otherNode = (Node) obj;
		if (otherNode.node.equals(this.node)) return true;
		return false;
	}

	private String node;
	private Node next;
	
	public Node(String node, Node next){
		this.node = node;
		this.next = next;
	}
	
	public String getNode(){
		return this.node;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public Node setNext(Node next){
		this.next = next;
		return this;
	}

	@Override
	public String toString() {
		return "Node [node=" + node + ", next=" + next + "]";
	}

	
	
	
}

