package algorithms1_3;

import java.util.Scanner;

public class OutPutCombination {
	public static int n;
	public static int r;
	public static int[] a;
	public static int[] b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		sc.close();
		a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		b = new int[r];
		dfs(0,0);
	}
	private static void dfs(int index,int start) {
		if(index >= r) {
			for(int i = 0; i < r; i++) {
				if(b[i] < 10) {
					System.out.print("  "+b[i]);
				}else {
					System.out.print(" "+b[i]);
				}
			}
			System.out.println();
			return;
		}
		
		for(int j = start; j < n; j++) {
			b[index] = a[j];
			dfs(index + 1, j + 1);
		}
	}

}
