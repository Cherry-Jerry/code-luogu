package algorithms1_7;

import java.util.Scanner;

public class SplitNaturalNum {
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		dfs(n ,1,"");
	}

	private static void dfs(int rest,int start, String str) {
		if(rest == 0) {
			String answer = str.substring(0, str.length()-1);
			if(answer.length() != 1) {
				System.out.println(answer);
			}else if(Integer.parseInt(answer) == 1) {
				System.out.println(1);
			}
			return;

		}
		for(int i = start; i <= rest; i++) {
			rest -= i;
			dfs(rest,i,str+i+"+");
			rest += i;
		}
	}
}
