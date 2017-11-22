import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[] numArr;
	static int[] visit;
	static int max = 0;
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static LinkedList<Integer> maxList = new LinkedList<Integer>();;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		numArr = new int[N + 1];
		visit = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			numArr[i] = sc.nextInt();
		}

		sc.close();

		for (int i = 1; i <= N; i++) {
			int tmp = dfs(i, 0, i);

			if (tmp == 1) {
				max++;
			}
			if (tmp > max) {
				max = tmp;
				maxList = new LinkedList<Integer>(list);
			}

			clear(N);
		}

		for (int i = 1; i <= N; i++) {
			if (i == numArr[i])
				maxList.add(i);
		}

		Ascending ascending = new Ascending();
		Collections.sort(maxList, ascending);

		System.out.println(max);

		for (int tmp : maxList) {
			System.out.println(tmp);
		}
	}

	public static int dfs(int start, int cnt, int first) {
		if (visit[start] == 1 && start == first)
			return cnt;
		if (visit[start] == 1 && start != first)
			return -1;
		if (cnt == 0 && start == numArr[start])
			return 1;

		if (visit[start] == 0) {
			cnt++;
			visit[start] = 1;
			list.add(start);
			cnt = dfs(numArr[start], cnt, first);
		}

		return cnt;
	}

	public static void clear(int N) {
		for (int i = 1; i <= N; i++)
			visit[i] = 0;

		list.clear();
	}
}

class Ascending implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

}
