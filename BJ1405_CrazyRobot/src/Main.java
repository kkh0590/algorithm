import java.util.Scanner;

public class Main {
	static int N;
	static double[] dirProb = new double[4];
	static int[][] visit;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i=0; i<4; i++) {
			dirProb[i] = sc.nextInt() / 100.0;
		}		
		visit = new int[N*2+1][N*2+1];
		
		sc.close();
		if(N==0) System.out.println(0.0);
		else System.out.println(dfs(N, N, N, 1.0));
	}
	
	public static double dfs(int y, int x, int moveCnt, double prob) {
		if(moveCnt == 0) {
			return prob;
		}
		
		visit[y][x] = 1;
		double tmp = 0.0;
		
		for(int i=0; i<4; i++) {
			if(visit[y+dy[i]][x+dx[i]] == 0) {
				tmp += dfs(y+dy[i], x+dx[i], moveCnt-1, prob*dirProb[i]);
			}
		}
		
		visit[y][x]=0;
		
		return tmp;
	}
}
