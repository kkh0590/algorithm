import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		sc.close();

		for (int bridgeCnt = 1; bridgeCnt < 100; bridgeCnt++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (dfs(y, x, bridgeCnt) == 0) {
						System.out.println(bridgeCnt);
						return;
					}

				}
			}
		}
	}

	public static int dfs(int y, int x, int bridgeCnt) {
		if (bridgeCnt == 0) {
			if (isConnected(y, x) == 0)
				return 0;
		}
		if (map[y][x] == 0 && bridgeCnt > 0) {
			map[y][x] = 1;

			for (int k = 0; k < 4; k++) {
				if (0 <= y + dy[k] && y + dy[k] < N && 0 <= x + dx[k] && x + dx[k] < N
						&& map[y + dy[k]][x + dx[k]] == 0) {
					if (dfs(y + dy[k], x + dx[k], bridgeCnt - 1) == 0)
						return 0;
				}
			}

			map[y][x] = 0;

		}

		return 1;
	}

	public static int isConnected(int y, int x) {
		int cnt = 0;

		for (int k = 0; k < 4; k++) {
			if (0 <= y + dy[k] && y + dy[k] < N && 0 <= x + dx[k] && x + dx[k] < N && map[y + dy[k]][x + dx[k]] == 1)
				cnt++;
		}

		if (cnt > 1) {
			return 0;
		} else
			return 1;

	}
}
