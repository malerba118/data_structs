import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MergeSort {

	public static List<Integer> sort(List<Integer> unsorted){
		
		if (unsorted.size() <= 1){
			return unsorted;
		}
		
		List<Integer> left = unsorted.subList(0, unsorted.size()/2);
		List<Integer> right =unsorted.subList(unsorted.size()/2, unsorted.size());
		
		return merge(sort(left), sort(right));
		
	}
	
	private static List<Integer> merge(List<Integer> left, List<Integer> right){
		
		List<Integer> merged = new ArrayList<Integer>();
		int leftIndex = 0;
		int rightIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()){
			
			if (left.get(leftIndex) <= right.get(rightIndex)){
				merged.add(left.get(leftIndex));
				leftIndex++;
			}
			else{
				merged.add(right.get(rightIndex));
				rightIndex++;
			}
		}
		
		for (int index = leftIndex; index < left.size(); index++){//Add remaining elements in left list
			merged.add(left.get(index));
		}
		for (int index = rightIndex; index < right.size(); index++){//Add remaining elements in right list
			merged.add(right.get(index));
		}
		
		return merged;
	}
}
