package algorithms1_2;

import java.util.Arrays;
import java.util.Scanner;

public class Jolly {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n]; 
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		int[] b = new int[n-1];
		for(int i = 0; i < n-1; i++) {
			b[i] = Math.abs(a[i]-a[i+1]);
		}
		Arrays.sort(b);
		boolean jolly = true;
		for(int i = 0; i < n-1; i++) {
			if(b[i] != i+1 ) {jolly=false; break;}
		}
		if(jolly) {
			System.out.println("Jolly");
		}else {
			System.out.println("Not jolly");
		}
	}

}
