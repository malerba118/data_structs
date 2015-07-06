import java.net.URL;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String root = System.getProperty("user.dir");
		String relPath = "/src/graphTest1.txt";
		
		Graph g = new Graph(root+relPath, true);
		System.out.println("Graph: " + g.getGraph() + "\n");
		
		DFS dfs = new DFS(g);
		BFS bfs = new BFS(g);
		
		System.out.println("BFS path: " + bfs.breadthFirstSearch("A", "F") + "\n");
		System.out.println("DFS is path found: " + dfs.depthFirstSearch("A", "F"));
	}

}
