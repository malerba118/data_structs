

public class Node{
		private String value;
		private Node left;
		private Node right;
		
		public Node(Node left, String value, Node right){
			this.setValue(value);
			this.setLeft(left);
			this.setRight(right);
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
