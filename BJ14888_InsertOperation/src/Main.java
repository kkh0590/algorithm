import java.util.Scanner;

public class Main {
	static int[] num;
	static int[] op = new int[4];
	static int N;
	static long MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}

		sc.close();

		dfs(1, num[0], op[0], op[1], op[2], op[3]);

		System.out.println(MAX);
		System.out.println(MIN);
	}

	public static void dfs(int idx, int sum, int plus, int minus, int mul, int div) {
		if (idx == N) {
			if (MAX < sum)
				MAX = sum;
			if (MIN > sum)
				MIN = sum;

			return;
		}

		if (plus > 0)
			dfs(idx + 1, sum + num[idx], plus - 1, minus, mul, div);
		if (minus > 0)
			dfs(idx + 1, sum - num[idx], plus, minus - 1, mul, div);
		if (mul > 0)
			dfs(idx + 1, sum * num[idx], plus, minus, mul - 1, div);
		if (div > 0)
			dfs(idx + 1, sum / num[idx], plus, minus, mul, div - 1);
	}
}
