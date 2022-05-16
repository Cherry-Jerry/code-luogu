package DP_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class NumberTriangles {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(token.nextToken());
		int [][] dp = new int[2][r+1];
		token = new StringTokenizer(br.readLine());
		dp[0][1] = Integer.parseInt(token.nextToken());
		int tmp;
		int up = 0;
		int down = 1;
		for(int i = 2; i <= r; ++i) {
			token = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; ++j) {
				dp[down][j] = Integer.parseInt(token.nextToken());
			}
			for(int j = 1; j <= i; ++j) {
				dp[down][j] = Math.max(dp[up][j-1],dp[up][j])+dp[down][j];
			}
			tmp = up;
			up = down;
			down = tmp;
		}
//		for(int i = 0; i < 2; ++i) {
//			for(int j = 1; j <= r; ++j) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
		int max= 0;
		for(int i = 1; i <= r; ++i) {
			if(dp[up][i] > dp[up][max]) {
				max = i;
			}
		}
		System.out.println(dp[up][max]);
	}
}
