import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int regionCnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		String str;

		for (int i = 0; i < N; i++) {
			str = sc.next();

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		sc.close();

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int regionSize;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				regionSize = dfs(i, j, 1);
				if (regionSize > 0) {
					regionCnt++;
					arrayList.add(regionSize);
				}
			}
		}
		
		Ascending ascending = new Ascending();
        Collections.sort(arrayList, ascending);

		System.out.println(regionCnt);
		
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}

	public static int dfs(int y, int x, int cnt) {
		if (map[y][x] == 0)
			return 0;

		map[y][x] = 0;

		if (x + 1 < N && map[y][x + 1] == 1) {
			cnt = dfs(y, x + 1, cnt + 1);
		}
		if (y + 1 < N && map[y + 1][x] == 1) {
			cnt = dfs(y + 1, x, cnt + 1);
		}
		if (x - 1 >= 0 && map[y][x - 1] == 1) {
			cnt = dfs(y, x - 1, cnt + 1);
		}
		if (y - 1 >= 0 && map[y - 1][x] == 1) {
			cnt = dfs(y - 1, x, cnt + 1);
		}

		return cnt;
	}
}

class Ascending implements Comparator<Integer> {
	 
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
 
}
