import java.util.Scanner;

public class Main {
	final static int SIZE = 100;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] input = new long[SIZE];
		int N = sc.nextInt();
		
		for(int i=0; i<3; i++) {
			input[i] = 1;
		}
		
		for(int i=3; i<5; i++) {
			input[i] = 2;
		}
		
		for(int i=5; i<SIZE; i++) {
			input[i] = input[i-5] + input[i-1];
		}
		
		for(int i=0; i<N; i++) {			
			System.out.println(input[sc.nextInt()-1]);
		}
		
		sc.close();
	}
}
