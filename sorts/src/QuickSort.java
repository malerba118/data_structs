import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class QuickSort {

	public static List<Integer> sort(List<Integer> unsorted){
		
		if (unsorted.size() <= 1){
		    return unsorted;
		}
		
		int pivot = unsorted.get(unsorted.size()/2);
		
		List<Integer> left = generateLeft(unsorted, pivot);
		List<Integer> right = generateRight(unsorted, pivot);
		List<Integer> pivotList = generatePivotList(unsorted, pivot);
		
		pivotList.addAll(0, sort(left));
		pivotList.addAll(sort(right));
		
		return pivotList;
	}
	
	
	public static List<Integer> generateLeft(List<Integer> unsorted, int pivot){
		List<Integer> left = new ArrayList<Integer>();
		for (int element : unsorted){
			if (element < pivot){
				left.add(element);
			}
		}
		return left;
	}
	
	public static List<Integer> generateRight(List<Integer> unsorted, int pivot){
		List<Integer> right = new ArrayList<Integer>();
		for (int element : unsorted){
			if (element > pivot){
				right.add(element);
			}
		}
		return right;
	}
	
	public static List<Integer> generatePivotList(List<Integer> unsorted, int pivot){
		List<Integer> pivotList = new ArrayList<Integer>();
		for (int element : unsorted){
			if (element == pivot){
				pivotList.add(element);
			}
		}
		return pivotList;
	}

}
