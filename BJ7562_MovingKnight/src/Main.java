import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, mapSize, x1, x2, y1, y2;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			mapSize = sc.nextInt();
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			map = new int[mapSize][mapSize];

			System.out.println(bfs());
		}

		sc.close();
	}

	public static int bfs() {
		Queue<Integer> xCoord = new LinkedList<Integer>();
		Queue<Integer> yCoord = new LinkedList<Integer>();

		xCoord.offer(x1);
		yCoord.offer(y1);

		map[y1][x1] = 1;
		
		int qSize, x, y, cnt = 0;

		while (!xCoord.isEmpty()) {
			qSize = xCoord.size();

			for (int i = 0; i < qSize; i++) {
				y = yCoord.poll();
				x = xCoord.poll();

				if (x == x2 && y == y2)
					return cnt;

				if (y - 2 >= 0 && x + 1 < mapSize && map[y - 2][x + 1] == 0) {
					yCoord.offer(y - 2);
					xCoord.offer(x + 1);
					map[y - 2][x + 1] = 1;
				}
				if (y - 1 >= 0 && x + 2 < mapSize && map[y - 1][x + 2] == 0) {
					yCoord.offer(y - 1);
					xCoord.offer(x + 2);
					map[y - 1][x + 2] = 1;
				}
				if (y + 1 < mapSize && x + 2 < mapSize && map[y + 1][x + 2] == 0) {
					yCoord.offer(y + 1);
					xCoord.offer(x + 2);
					map[y + 1][x + 2] = 1;
				}
				if (y + 2 < mapSize && x + 1 < mapSize && map[y + 2][x + 1] == 0) {
					yCoord.offer(y + 2);
					xCoord.offer(x + 1);
					map[y + 2][x + 1] = 1;
				}
				if (y + 2 < mapSize && x - 1 >= 0 && map[y + 2][x - 1] == 0) {
					yCoord.offer(y + 2);
					xCoord.offer(x - 1);
				}
				if (y + 1 < mapSize && x - 2 >= 0 && map[y + 1][x - 2] == 0) {
					yCoord.offer(y + 1);
					xCoord.offer(x - 2);
					map[y + 1][x - 2] = 1;
				}
				if (y - 1 >= 0 && x - 2 >= 0 && map[y - 1][x - 2] == 0) {
					yCoord.offer(y - 1);
					xCoord.offer(x - 2);
					map[y - 1][x - 2] = 1;
				}
				if (y - 2 >= 0 && x - 1 >= 0 && map[y - 2][x - 1] == 0) {
					yCoord.offer(y - 2);
					xCoord.offer(x - 1);
					map[y - 2][x - 1] = 1;
				}
			}

			cnt++;

			// print();
		}

		return 0;
	}

	public static void print() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				System.out.print(map[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println();
	}
}
