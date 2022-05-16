package algorithms1_3;

import java.util.Scanner;

public class PERKET {
	public static int[][] a = new int[2][11];
	public static int sour = 1;
	public static int bitter = 0;
	public static int minn = Integer.MAX_VALUE;
	public static int n;
	public static int addNum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			a[0][i] = sc.nextInt();
			a[1][i] = sc.nextInt();
		}
		sc.close();
		search(1);
		System.out.println(minn);
	}
	private static void search(int index) {
		if(index > n) {
			if(addNum > 0) { //排除 不添加调料的可能
				minn = Math.min(minn, Math.abs(sour-bitter));
			}
			return;
		}
		sour *=a[0][index];
		bitter +=a[1][index];
		addNum++;
		search(index+1);
		addNum--;
		sour /=a[0][index];
		bitter -=a[1][index];
		
		
		//do nothing
		search(index+1);
		
	}

}
