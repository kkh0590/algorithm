import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long input = sc.nextInt();

		sc.close();

		System.out.println((9 * Math.pow(2, input - 1) - Math.pow(2, input - 1)) % 1000000000);
	}
}
