import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

	/**
	 * @param args
	 */
public static void main(String[] args) {
		
		List<Integer> unsorted = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 1000000; i++){
			unsorted.add(r.nextInt(100000));
		}
		
		long start;
		long finish;
		
		System.out.println("Time comparison to sort 1,000,000 elements: \n");

		start = System.currentTimeMillis();
		
		QuickSort.sort(unsorted);
		
		finish = System.currentTimeMillis();
		
		System.out.format("QuickSort duration: %f%n \n", (finish-start)/1000.0);
		
		
		
		start = System.currentTimeMillis();
		
		MergeSort.sort(unsorted);
		
		finish = System.currentTimeMillis();
		
		System.out.format("MergeSort duration: %f%n \n", (finish-start)/1000.0);
		
		
		start = System.currentTimeMillis();
		
		HeapSort.sort(unsorted);
		
		finish = System.currentTimeMillis();
		
		System.out.format("HeapSort duration: %f%n \n", (finish-start)/1000.0);
		
		
	}

}
