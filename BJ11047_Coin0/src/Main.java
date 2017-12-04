import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int coinCnt = sc.nextInt();
		int goal = sc.nextInt();
		int[] coinArr = new int[coinCnt];
		int cnt=0;

		for (int i = 0; i < coinCnt; i++) {
			coinArr[i] = sc.nextInt();
		}
		
		sc.close();

		for (int i = (coinArr.length - 1); i >= 0; i--) {
			while (goal - coinArr[i] >= 0) {
				goal -= coinArr[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
