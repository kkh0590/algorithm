import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		if (N >= 6) {

			int[] dp = new int[N + 1];

			dp[0] = 1;	
			dp[2] = 3;
			dp[4] = 11;

			for (int i = 6; i <= N; i += 2) {
				dp[i] = dp[i - 2] * 4 - dp[i - 4];
			}

			System.out.println(dp[N]);
		} else {
			if (N % 2 == 1) {
				System.out.println("0");
			} else if (N == 2) {
				System.out.println("3");
			} else if (N == 4) {
				System.out.println("11");
			}
		}
	}
}
