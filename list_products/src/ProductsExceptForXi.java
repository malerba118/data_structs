import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Problem statement: Given a list x of length n, produce a list b such that b[i], 0<=i<n, 
 * is the product of all elements in x excluding x[i]. Do so in O(n) time without using division.
 *  
 * Example list: x = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * aboveXi = [1, 1*9, 1*9*8, 1*9*8*7,..., 1*9*8*7*6*5*4*3*2]
 * belowXi = [1, 1*1, 1*1*2, 1*1*2*3,..., 1*1*2*3*4*5*6*7*8]
 * productList = [aboveXi[0]*belowXi[8], aboveXi[1]*belowXi[7],..., aboveXi[8]*belowXi[0]]
 * @author Austin
 *
 */
public class ProductsExceptForXi {

	private static LinkedList<Integer> X;
	private static LinkedList<Integer> aboveXi = new LinkedList<Integer>();
	private static LinkedList<Integer> belowXi = new LinkedList<Integer>();
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		X = new LinkedList<Integer>();
		for (int number = 1; number < 10; number++){
			X.add(number);
		}
		
		populateBelowXi();
		populateAboveXi();
		System.out.println("X: " + X);
		System.out.println("belowXi: " + belowXi);
		System.out.println("aboveXi: " + aboveXi);
		System.out.println("products: " + multiplyLists());
		
		
	}

	
	public static void populateBelowXi(){
		belowXi.add(1);
		for (int index = 0; index < X.size() - 1; index++){
			belowXi.add(belowXi.getLast() * X.get(index));
		}
	}
	
	public static void populateAboveXi(){
		LinkedList<Integer> reverse = reverseOfX();
		aboveXi.add(1);
		for (int index = 0; index < reverse.size() - 1; index++){
			aboveXi.add(aboveXi.getLast() * reverse.get(index));
		}
		
	}
	
	public static LinkedList<Integer> reverseOfX(){
		LinkedList<Integer> reverse = new LinkedList<Integer>();
		
		for (int index = X.size() - 1; index >= 0; index--){
			reverse.add(X.get(index));
		}
		return reverse;
	}
	
	public static LinkedList<Integer> multiplyLists(){
		LinkedList<Integer> productsList = new LinkedList<Integer>();
		
		for (int index = 0; index < X.size(); index++){
			productsList.add(aboveXi.get(X.size() - 1 - index) * belowXi.get(index));
		}
		
		return productsList;
	}
}
