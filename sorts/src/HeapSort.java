import java.util.ArrayList;
import java.util.List;


public class HeapSort {
	
	private static List<Integer> heap = new ArrayList<Integer>();
	private static List<Integer> sorted = new ArrayList<Integer>();
	
	
	public static List<Integer> sort(List<Integer> unsorted){
		for (int element : unsorted){
			addElement(element);
		}
		
		while (!heap.isEmpty()){
			sorted.add(removeMin());
		}
		return sorted;
	}

	public static void addElement(Integer element){
		heap.add(element);
		upsift();
	}
	
	public static void upsift(){
		int index = heap.size() - 1;
		while (index >= 0){
			
			int parent = parent(index);
			if (parent < 0) break;
			
			if (heap.get(index) < heap.get(parent)){
				swap(index, parent);
				index = parent;
			}
			else{
				break;
			}
			
		}
	}
	
	private static int removeMin(){
		swap(0, heap.size() - 1);
		int min = heap.remove(heap.size() - 1);
		downsift();
		return min;
		
	}
	
	private static void downsift(){
		int index = 0;
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);
		int childIndex;
		
		childIndex = chooseChild(index, leftChild, rightChild);
		
		while(childIndex != -1){
			swap(index, childIndex);
			index = childIndex;
			childIndex = chooseChild(childIndex, leftChild(childIndex), rightChild(childIndex));
		}
	}
	
    private static int chooseChild(int index, int leftChild, int rightChild){
    	if (rightChild >= heap.size())
    		if (leftChild >= heap.size()){
    			return -1;
    		}
    		else if(heap.get(index) > heap.get(leftChild)){
    			return leftChild;
    		}
    		else{
    			return -1;
    		}
    	if (leftChild < heap.size()&& rightChild < heap.size()){
    		if(heap.get(index) > heap.get(leftChild) || heap.get(index) > heap.get(leftChild)){
    			if (heap.get(leftChild) <= heap.get(rightChild)){
    				return leftChild;
    			}
    			else {
    				return rightChild;
    			}
    		}
    	}
    	return -1;
    }
	
	private static int parent(int child){
		
		if (child == 0) return -1;
		
		return (child-1)/2;
	}
	
	private static int leftChild(int parent){
		return parent*2 + 1;
	}
	
	private static int rightChild(int parent){
		return parent*2 + 2;
	}
	
	private static void swap(int index, int parent){
		
		int elementAtIndex = heap.get(index);
		int elementAtParent = heap.get(parent);
		
		heap.set(index, elementAtParent);
		heap.set(parent, elementAtIndex);
		
	}
	
}
