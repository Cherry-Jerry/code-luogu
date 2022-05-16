package DP_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EXPTimes5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(tokenizer.nextToken());
		int x = Integer.parseInt(tokenizer.nextToken());
		int[] lose = new int[n+1];
		int[] win = new int[n+1];
		int[] drug = new int[n+1];
		int maxWin = 0;
		for(int i = 1; i <= n; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			lose[i] = Integer.parseInt(tokenizer.nextToken());
			win[i] = Integer.parseInt(tokenizer.nextToken());
			if(win[i] > maxWin) {
				maxWin = win[i];
			}
			drug[i] = Integer.parseInt(tokenizer.nextToken());
		}
		long[] dp = new long[x+1];
		for(int i = 1; i <= n; i++) {
			for(int j = x; j >= 0; j--) {
				if(j -drug[i] >= 0) {
					dp[j] = Math.max(dp[j]+lose[i],dp[j-drug[i]]+win[i]);
				}else {
					dp[j] = dp[j]+lose[i];
				}
			}
			System.out.print("times["+i+"]:");
			for(int j = 0; j <= x; j++) {
				System.out.print(dp[j]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[x]*5);
	}
}
