import java.util.Scanner;

public class Main {
	static boolean[][] social;
	static int[][] step;
	static boolean[] visit;
	static int userNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		userNum = sc.nextInt();
		int relation = sc.nextInt();

		social = new boolean[userNum + 1][userNum + 1];
		visit = new boolean[userNum];

		for (int i = 0; i < relation; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			social[y][x] = social[x][y] = true;
		}

		sc.close();

		for (int i = 0; i < userNum; i++) {
			dfs(i, 0);
		}

	}

	public static int dfs(int start, int cnt) {
		if(visit[start] == true) return cnt;
		
		for(int i=1; i<userNum+1; i++) {
			if(social[start][i] == true && visit[i] == false) {
				cnt = dfs(i, cnt+1);
			}
		}
		
		return cnt;
	}
}
