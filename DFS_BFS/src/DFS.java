import java.util.ArrayList;
import java.util.HashMap;


public class DFS {
    Graph g;
    HashMap<Vertex, ArrayList<Vertex>> graph;
    HashMap<Vertex, Vertex> predecessors;
    Boolean found = false;
    
    DFS(Graph g){
    	this.g = g;
    	this.graph = g.getGraph();
    	this.predecessors = new HashMap<Vertex, Vertex>();
    }
    
    public boolean depthFirstSearch(String startString, String endString){
    	Vertex start = new Vertex(startString);
		Vertex end = new Vertex(endString);
    	this.predecessors.put(start, null);
    	search(start, end);
    	return found;
    }
    
    public void search(Vertex start, Vertex end){
    	
    	if (start.equals(end)){
    		found = true;
    	}
    	for (Vertex neighbor : graph.get(start)){
    		if (! this.predecessors.containsKey(neighbor)){
    			this.predecessors.put(neighbor, start);
        		search(neighbor, end);
    		}
    		
    	}
    	
    }
}
