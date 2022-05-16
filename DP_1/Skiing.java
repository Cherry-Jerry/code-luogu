package DP_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class State1 implements Comparable<State1>{
	int x;
	int y;
	int h;
	@Override
	public int compareTo(State1 o) {
		if(this.h - o.h != 0) {
			return (this.h - o.h);
		}else {
			if(this.x-o.x != 0) {
				return this.x-o.x;
			}else {
				return this.y-o.y;
			}
		}

	}
	public State1(int x, int y, int h) {
		super();
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
public class Skiing {
	public static void main(String[] args)throws IOException{
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		TreeSet<State1> states = new TreeSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());
		int[][] dp = new int[R+1][C+1];
		int[][] high = new int [R+1][C+1];
		for(int i = 1; i <= R; ++i) {
			tokenizer = new StringTokenizer(br.readLine());
			for(int j = 1; j <= C; ++j) {
				high[i][j] = Integer.parseInt(tokenizer.nextToken());
				states.add(new State1(i,j,high[i][j]));
				
			}
		}
		for(int i = 1; i <= R; ++i) {
			for(int j = 1; j <= C; ++j) {
				State1 s = states.pollFirst();
				for(int k = 0; k < 4; k++) {
					int nextX = s.x+dx[k];
					int nextY = s.y+dy[k];
					if(nextX >= 1 &&nextY >= 1 && nextX <= R && nextY <= C
							&&high[nextX][nextY] < s.h){
						dp[s.x][s.y] = Math.max(dp[s.x][s.y], dp[nextX][nextY]+1);
					}
				}
				if(dp[s.x][s.y] == 0) {
					dp[s.x][s.y] = 1;
				}
			}
		}
//		for(int i = 1; i <= R; ++i) {
//			for(int j = 1; j <= C; ++j) {
//				if(dp[i][j] > 10) {
//					System.out.print(" "+dp[i][j]);
//				}else {
//					System.out.print("  "+dp[i][j]);
//				}
//			}
//			System.out.println();
//		}
		int maxX = 0;
		int maxY = 0;
		for(int i = 1; i <= R; ++i) {
			for(int j = 1; j <= C; ++j) {
				if(dp[i][j] > dp[maxX][maxY]) {
					maxX = i;
					maxY = j;
				}
			}
		}
		System.out.println(dp[maxX][maxY]);
	}

}
