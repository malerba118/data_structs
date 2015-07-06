import java.util.ArrayList;


public class Main {

	/**
	 * Generate tree from preorder and inorder lists
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> preorder = new ArrayList<String>();
		ArrayList<String> inorder = new ArrayList<String>();
		
		for (String element : new String[]{"A", "B", "C", "D", "E", "F"}){
			preorder.add(element);
		}
		for (String element : new String[]{"C", "B", "D", "A", "F", "E"}){
			inorder.add(element);
		}
        Tree t = new Tree(preorder, inorder);
        System.out.println("Preorder: ");
        t.preorderTraversal(t.getTree());
        System.out.println("Inorder: ");
        t.inorderTraversal(t.getTree());
	}

}
