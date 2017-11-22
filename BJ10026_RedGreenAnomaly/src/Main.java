import java.util.Scanner;

public class Main {
	static char[][] arr;
	static int[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int individualCnt = 0;
	static int togetherCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		arr = new char[N][N];
		visit = new int[N][N];
		String tmp;

		for (int i = 0; i < N; i++) {
			tmp = sc.next();
			
			//System.out.println(tmp);
			
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}

		sc.close();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(individualDfs(i, j, N, arr[i][j]) == 1) individualCnt++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for(int j=0; j<N; j++) {
				visit[i][j] = 0;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(togetherDfs(i, j, N, arr[i][j]) == 1) togetherCnt++;
			}
		}
		
		System.out.println(individualCnt + " " + togetherCnt);

	}

	public static int individualDfs(int y, int x, int N, char prev) {
		if (visit[y][x] == 1)
			return 0;

		visit[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			if (0 <= y + dy[i] && y + dy[i] < N && 0 <= x + dx[i] && x + dx[i] < N
					&& arr[y + dy[i]][x + dx[i]] == prev 
					&& visit[y+dy[i]][x+dx[i]] == 0) {
				individualDfs(y + dy[i], x + dx[i], N, arr[y][x]);
			} 
		}
		
		return 1;
	}
	
	public static int togetherDfs(int y, int x, int N, char prev) {
		if (visit[y][x] == 1)
			return 0;
		
		visit[y][x] = 1;
		
		for (int i = 0; i < 4; i++) {
			if (0 <= y + dy[i] && y + dy[i] < N && 0 <= x + dx[i] && x + dx[i] < N
					&& (arr[y + dy[i]][x + dx[i]] == prev
					|| (prev == ('R') && arr[y + dy[i]][x + dx[i]] == 'G')
					|| (prev == 'G' && arr[y + dy[i]][x + dx[i]] == 'R')) 
					&& visit[y+dy[i]][x+dx[i]] == 0) {
				togetherDfs(y + dy[i], x + dx[i], N, arr[y][x]);
			} 
		}
		
		return 1;
	}
}
