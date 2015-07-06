import java.util.ArrayList;


public class Tree {

	private ArrayList<String> preOrder;
	private Node tree;
	
	public Tree(ArrayList<String> preOrder, ArrayList<String> inOrder){
		
		this.preOrder = preOrder;
		
		this.tree = genTree(preOrder.get(0), inOrder);
		
	}
	
	
	private Node genTree(String val, ArrayList<String> inOrder){
		
		ArrayList<String> left = getLeftInOrder(inOrder, val);
		ArrayList<String> right = getRightInOrder(inOrder, val);
		
		String leftVal = getVal(val, left);//get value of left child
		String rightVal = getVal(val, right);//get value of right child
		
		if (leftVal == null && rightVal == null){//base cases
			return new Node(null, val, null);
		}
		else if (leftVal == null){
			return new Node(null, val, genTree((rightVal), right));
		}
		else if (rightVal == null){
			return new Node(genTree(leftVal, left), val, null);
		}
		return new Node(genTree(leftVal, left), val, genTree(rightVal, right));//recursive step
	}

	private String getVal(String val, ArrayList<String> inOrder){
		for (String element : this.preOrder){
			if (inOrder.contains(element)){
				return element;
			}
		}
		
		return null;
	}
	
	private ArrayList<String> getLeftInOrder(ArrayList<String> inOrder,
			String val) {
		ArrayList<String> leftInOrder = new ArrayList<String>();
		for (String element : inOrder){
			if (element.equals(val)){
				break;
			}
			leftInOrder.add(element);
		}
		return leftInOrder;
	}
	

	private ArrayList<String> getRightInOrder(ArrayList<String> inOrder,
			String val) {
		ArrayList<String> rightInOrder = new ArrayList<String>();
		boolean valFound = false;
		for (String element : inOrder){
			if (valFound){
				rightInOrder.add(element);
			}
			if (element.equals(val)){
				valFound = true;
			}
		}
		return rightInOrder;
	}
	
	public void preorderTraversal(Node n){
		if (n==null){
			
		}
		else{
			System.out.println(n.getValue());
			preorderTraversal(n.getLeft());
			preorderTraversal(n.getRight());
		}
		
	}
	
	public void inorderTraversal(Node n){
		if (n==null){
			
		}
		else{
			inorderTraversal(n.getLeft());
			System.out.println(n.getValue());
			inorderTraversal(n.getRight());
		}
		
	}

	public Node getTree() {
		return tree;
	}

	
}
