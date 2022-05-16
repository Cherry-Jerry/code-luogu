package algorithms1_3;

import java.util.Scanner;

public class SelectNum {
	public static int n;
	public static int k;
	public static int[] a;
	public static int[] b;
	public static int counter = 0;
	public static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		b = new int[k];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		dfs(0,0);
		System.out.println(counter);
		
	}
	static void dfs(int u , int start) {
		if(u >= k){
			for(int i = 0; i < k ;i++) {
				sum+= b[i];
			}
			if(isPrime(sum)){
				counter++;
			}
			sum = 0;
			return;
		}
		
		for(int j = start; j < n; j++) {
			b[u] = a[j];
			dfs(u+1,j+1);
		}
	}
	private static boolean isPrime(int sum) {
		for(int i = 2; i < Math.sqrt(sum); i++) {
			if(sum % i == 0) {
				return false;
			}
		}
		return true;
	}

}
