import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		int[] input = new int[N];
		int[] output = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(input);
		
		for(int i=0; i<N; i++) {
			sum += input[i];
			output[i] = sum;
		}
		
		sum=0;
		
		for(int i=0; i<N; i++) {
			sum += output[i];
		}
		
		System.out.println(sum);
	}
}
