import java.util.Scanner;

public class Main {
	static int max = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt, W, E;

		cnt = sc.nextInt();
		
		for(int i=0; i<cnt; i++) {
			W = sc.nextInt();
			E = sc.nextInt();
			System.out.println(solve(W, E));
		}
		
		sc.close();
	}
	
	public static long solve(int W, int E) {
		int[][] dp = new int[W+1][E+1];
		
		for(int i=0; i< E+1; i++) {
			dp[0][i] = 0;
		}
		
		for(int i=0; i<W+1; i++) {
			dp[i][0] = 0;
		}
		
		for(int i=1; i<E+1; i++) {
			dp[1][i] = i;
		}
		
		for(int i=2; i<W+1; i++) {
			for(int j=1; j<E+1; j++) {
				if(i==j) dp[i][j] = 1;
				if(j<i) dp[i][j] = 0;
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				}
			}
		}
		
		return dp[W][E];
	}
}
