package algorithms1_7;

import java.util.Scanner;

public class WordsSolitaire {
	public static int n;
	public static int[][] match;
	public static String[] words;
	public static int[] use;
	public static int maxLength = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		match = new int[n+1][n+1];
		words = new String[n+1];
		use = new int[n+1];
		for(int i = 1; i <= n; i++) {
			words[i] = sc.next();
		}
		String start = sc.next();
		sc.close();
		//计算plusLength数组 计算不了代入零
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				String str1 = words[i];
				String str2 = words[j];
				for(int k = str1.length()-1; k != 0 ;k--) {
					int l = str1.length()-k;
					if(l < str2.length()  
							&& str1.substring(k).equals(str2.substring(0, l))) {
						match[i][j] = l;
						break;
					}
				}
				
			}
		}
//		System.out.println();//检查
//		for(int i = 1; i <= n; i++) {
//			for(int j = 1; j <= n; j++) {
//				System.out.print(length[i][j]);
//			}
//			System.out.println();
//		}
		for(int i =1; i <= n; i++) {
			if(words[i].substring(0,1).equals(start)) {
				use[i]++;
				dfs(i, words[i].length());
			}
		}
		System.out.println(maxLength);
	}

	private static void dfs(int last,int sum) {
		//System.out.println(sum);
		maxLength = Math.max(maxLength, sum);
		for(int j = 1; j <= n; j++) {
			if(match[last][j] != 0 && use[j] < 2) {
				use[j]++;
				dfs(j,sum + words[j].length()-match[last][j]);
				use[j]--;
			}
		}
	}
}
