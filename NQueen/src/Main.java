import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Queen�� ������ ü������ ���� �Է��ϼ��� : ");
		
		int N = scan.nextInt();
		
		N_Queens q = new N_Queens(N);
		q.back_tracking(0);
	}
}
