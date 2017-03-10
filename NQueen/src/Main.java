import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Queen의 갯수와 체스판의 수를 입력하세요 : ");
		
		int N = scan.nextInt();
		
		N_Queens q = new N_Queens(N);
		q.back_tracking(0);
	}
}
