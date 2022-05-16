package algorithms1_2;

import java.util.Arrays;
import java.util.Scanner;

public class BookshelfAndCow {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long B = sc.nextLong();
		long[] H = new long[N];
		for(int i = 0; i < N; i++) {
			H[i] = sc.nextLong();
		}
		sc.close();
		Arrays.sort(H);
		int j;
		for(j = 0; B > 0; j++) {
			B -= H[H.length-1-j];
		}
		System.out.print(j);
	}

}
