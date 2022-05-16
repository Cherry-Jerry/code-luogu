package algorithms1_4;

import java.util.Scanner;

public class SpendAllMoney{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] a = new int[N+1];
		for(int i = 1; i <= N; i++) {
		a[i] = sc.nextInt();
		}
		sc.close();
		int[][] f = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(j - a[i] < 0) {
					f[i][j] = f[i-1][j];
				}else if(j - a[i] == 0) {
					f[i][j] = 1 + f[i-1][j];
				}else if(j -a[i] > 0) {
					f[i][j] = f[i-1][j-a[i]]+f[i-1][j];
				}
			}
		}
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				System.out.print(f[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(f[N][M]);
	}
}

// ±©Á¦ËÑË÷³¬Ê± 90%AC
//public class SpendAllMoney {
//	public static int counter = 0;
//	public static int N;
//	public static int M;
//	public static int[] a;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		a = new int[N+1];
//		for(int i = 1; i <= N; i++) {
//			a[i] = sc.nextInt();
//		}
//		sc.close();
//		spend(1);
//		System.out.println(counter);
//	}
//	private static void spend(int start) {		
//		if(M <= 0) {
//			if(M == 0) {
//				counter++;
//			}
//			return;
//		}
//		for(int i = start; i <= N; i++) {
//				M -= a[i];
//				spend(i+1);
//				M += a[i];
//		}
//	}
//}
