import java.util.Scanner;

public class Main {
	static int[] a = new int[20001];
	static int[] b = new int[20001];
	static int[] k = new int[20001];
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		sc.close();
	}

	static long getNum(int i, long limit) {
		if (limit < a[i])
			return 0;
		int bb = b[i] > (int) limit ? (int) limit : b[i];
		int x = (bb - a[i]) / k[i] + 1;
		return x;
	}

	static long getNums(long limit) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += getNum(i, limit);
		}
		return sum;
	}

	static void p_search(long min, long max) {
		if (min >= max) {
			if (min == Integer.MAX_VALUE)
				System.out.println("NOTHING\n");
			else
				System.out.println(min);
				System.out.println(getNums(min) - getNums(min - 1));
			return;
		}
		long med = (min + max) / 2;
		if (getNums(med) % 2 == 1) {
			p_search(min, med);
		} else {
			p_search(med + 1, max);
		}
	}
}
