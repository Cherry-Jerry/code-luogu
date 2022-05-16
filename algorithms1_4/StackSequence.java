package algorithms1_4;

import java.util.Scanner;

//卡特兰数序列通项： Cn = Cn-1*(4*n-2)/(n+1)
public class StackSequence {
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		long[] a = new long[N+1];
		a[0] = 1;
		for(int i = 1; i <= N; i++) {
			a[i] = a[i-1]*(4*i-2)/(i+1);
		}
		System.out.println(a[N]);
//		for(int i = 0; i <= N; i++) {
//			System.out.print(a[i]+" ");
//		}
	}

}
