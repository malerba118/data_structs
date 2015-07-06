import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

	//private HashMap<E, Vertex> vertices;
	private HashMap<Vertex, ArrayList<Vertex>> graph;
	private int numVertices;
	private int numEdges;
	private boolean directed;
	public static final int PARENT_INDEX = 0;
	public static final int CHILD_INDEX = 1;
	
	public Graph(String filePath, boolean directed){
		
		this.directed = directed;
		initializeGraph();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			String[] lineArray;
			while ((line = br.readLine()) != null){
				lineArray = line.split(" ");
				addEdge(lineArray[PARENT_INDEX], lineArray[CHILD_INDEX]);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public HashMap<Vertex, ArrayList<Vertex>> getGraph() {
		return graph;
	}

	private void initializeGraph(){
		this.graph = new HashMap<Vertex, ArrayList<Vertex>>(); 
	}
	
	private void addEdge(String parent, String child){
		Vertex parentVertex = new Vertex(parent);
		Vertex childVertex = new Vertex(child);
		
		if (!graph.containsKey(parentVertex)) graph.put(parentVertex, new ArrayList<Vertex>());
		if (!graph.containsKey(childVertex)) graph.put(childVertex, new ArrayList<Vertex>());
		
		if (! this.directed){
			graph.get(childVertex).add(parentVertex);
		}
		
		graph.get(parentVertex).add(childVertex);
	}
	
}
