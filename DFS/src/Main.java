
public class Main {
	public static int[][] adjacencyMatrix = {
			{ 0, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 1, 0, 1 },
			{ 0, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 1, 0, 0, 1, 0 }
		};
	public static int size = 8;
	public static int[] visit = {
		0, 0, 0, 0, 0, 0, 0, 0
	};

	public static void main(String[] args) {
		Main.DFS(0);
	}
	
	public static void DFS(int v) {
		visit[v] = 1;
		
		for(int i=0; i<size; i++) {
			if(adjacencyMatrix[v][i] != 0 && visit[i] == 0) {
				System.out.println(v + " -> " + i + "∑Œ ¿Ãµø");
				DFS(i);
			}
		}
	}
}
