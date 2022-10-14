package data_structure;

import java.util.Scanner;

public class P1996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();

		int[] a = new int[n];
		for(int i = 1; i <= n; i++) {
			a[i-1] = i;
		}
		
		int step = 0;
		int index = 0;
		for(int i = 1; i <= n; i++) {
			step = 0;
			while(step < m-1 || a[index] == 0) {
				if(a[index] != 0) {
					step++;
				}
				index++;
				if(index >= n) {
					index = 0;
				}
			}
			System.out.print(a[index]+" ");
			a[index] = 0;
		}
	}
}
