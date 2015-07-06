import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {

	Graph g;
	HashMap<Vertex, ArrayList<Vertex>> graph;
	private LinkedList<Vertex> queue;
	private HashMap<Vertex, Vertex> predecessors;
	
	public BFS(Graph g){
		this.g = g;
		this.graph = g.getGraph();
		this.queue = new LinkedList<Vertex>();
		this.predecessors = new HashMap<Vertex, Vertex>();
		
		
	}
	
	public ArrayList<Vertex> breadthFirstSearch(String startString, String endString){
		Vertex start = new Vertex(startString);
		Vertex end = new Vertex(endString);
		this.queue.addFirst(start);
		this.predecessors.put(start, null);
		Vertex curr;
		
		while (!queue.isEmpty()){
			
			curr = queue.removeLast();
			if (curr.equals(end)) break;
			
			for (Vertex neighbor : this.graph.get(curr)){
				if (! this.predecessors.containsKey(neighbor)){
					this.predecessors.put(neighbor, curr);
					queue.addFirst(neighbor);
				}
			}
		}
		return getPath(start, end);
	}
	
	private ArrayList<Vertex> getPath(Vertex start, Vertex end){
		
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		Vertex curr = end;
		if (!predecessors.containsKey(end)) return path;
		path.add(end);
		
		while (predecessors.get(curr) != null){
			
			Vertex predecessor = predecessors.get(curr);
			path.add(predecessor);
			curr = predecessor;
			
		}
		
		Vertex temp;
		int i = 0;
		int j = path.size()-1;
		
		while (i < j){
			
			temp = path.get(i);
			path.set(i, path.get(j));
			path.set(j, temp);
			
			i++;
			j--;
		}
			
		return path;
	}
}
