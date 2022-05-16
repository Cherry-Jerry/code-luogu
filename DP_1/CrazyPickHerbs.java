package DP_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CrazyPickHerbs {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[] waste = new int[m+1];
		int[] value = new int[m+1];
		
		for(int i = 1; i <= m ;++i) {
			tokenizer = new StringTokenizer(br.readLine());
			waste[i] = Integer.parseInt(tokenizer.nextToken());
			value[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		long[] dp = new long[t+1];
		for(int i = 1; i <= m; ++i) {
			for(int j = waste[i]; j <= t; ++j) {
					dp[j] = Math.max(dp[j-waste[i]]+value[i], dp[j]); 
			}
//			for(int j = 1; j <= t; ++j) {
//				System.out.print(dp[j]+" ");
//			}
//			System.out.println();
		}
		
		System.out.println(dp[t]);
	}
}
