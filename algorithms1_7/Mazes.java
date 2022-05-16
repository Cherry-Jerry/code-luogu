package algorithms1_7;

import java.util.Scanner;

public class Mazes {
	public static int N;
	public static int M;
	public static int FX;
	public static int FY;
	public static int[][] map;
	public static int dx[] = {-1,1,0,0};
	public static int dy[] = {0,0,-1,1};
	public static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		for(int i = 0; i <= M; i++) {
			map[0][i] = -1;
		}
		for(int i = 0; i <= N; i++) {
			map[i][0] = -1;
		}
		int T = sc.nextInt();
		int SX = sc.nextInt();
		int SY = sc.nextInt();
		FX = sc.nextInt();
		FY = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			map[sc.nextInt()][sc.nextInt()] = -1;
		}
		sc.close();
		search(SX,SY);
		System.out.println(ans);
	}
	private static void search(int x, int y) {
		if(x == FX && y == FY) {
			ans++;
			return;
		}
		map[x][y] = 1;
		for(int i = 0; i < 4; i++) {
			if(x+dx[i] >= 0 && y+dy[i] >=0 
					&& x+dx[i] <= N &&  y+dy[i] <= M
					&& map[x+dx[i]][y+dy[i]] == 0) {
				search(x+dx[i],y+dy[i]);
			}
		}
		map[x][y] = 0;	
	}
}
