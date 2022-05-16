package DP_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 01背包问题
public class PickHerbs {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		int[] waste = new int[M+1];
		int[] value = new int[M+1];
		int[] dp = new int[T+1];
		for(int i = 1; i <= M; ++i) {
			tokenizer = new StringTokenizer(br.readLine());
			waste[i] = Integer.parseInt(tokenizer.nextToken());
			value[i] = Integer.parseInt(tokenizer.nextToken());
		}

		for(int i = 1; i <= M; ++i) {//考虑第i个草药
			for(int j = T ; j-waste[i] >= 0 ; --j) {// j:当前剩余时间
				dp[j] = Math.max(dp[j-waste[i]]+value[i], dp[j]);
			}
//			for(int j = 1 ; j <= T ; ++j) {
//				if(dp[j]<10) {
//					System.out.print(dp[j]);
//				}else if(dp[j]<100) {
//					System.out.print(dp[j]);
//				}else  if(dp[j]<1000){
//					System.out.print(dp[j]);
//				}else {
//					System.out.print(dp[j]);
//				}
//
//			}
//			System.out.println();
//			
		}
		
		System.out.println(dp[T]);
	}
}
