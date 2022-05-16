package algorithms1_7;

import java.util.Scanner;

public class CheckerChallenge {
	public static int n;
	public static int[][] chessboard;
	public static int[] method;
	public static int counter = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		chessboard = new int[n+1][n+1];
		method = new int[n+1];
		dfs(1);
		System.out.println(counter);
	}
	private static void dfs(int y) {
		if(y > n) {
			counter++;
			if(counter <= 3) {
				for(int i = 1; i <= n; ++i) {
					System.out.print(method[i]+" ");
				}
				System.out.print("\n");
			}
			return;
		}
		for(int x = 1; x <= n; ++x) {
			if(chessboard[x][y] == 0) {
				method[y] = x;
				control(x,y,1);
				dfs(y+1);
				control(x,y,-1);
			}
		}
	}
	private static void control(int x, int y, int value) {
		// x,y 所在行，主对角，副对角全+value（列省略不操作）
		for(int i = 1; i <= n; ++i) {
			chessboard[x][i] += value;// 同行
		}
		for(int i = 1; i <= n; ++i) {
			if(x+i <= n && y+i <= n) {
				chessboard[x+i][y+i]+= value;// 主对角正方向
			}else {
				break;
			}
		}
		for(int i = 1; i <= n; ++i) {
			if(x-i >= 1 && y-i >= 1) {
				chessboard[x-i][y-i]+= value;// 主对角负方向
			}else {
				break;
			}
		}
		for(int i = 1; i <= n; ++i) {
			if(x-i >= 1 && y+i <= n) {
				chessboard[x-i][y+i]+= value;// 副对角正方向
			}else {
				break;
			}
		}
		for(int i = 1; i <= n; ++i) {
			if(x+i <= n && y-i >= 1) {
				chessboard[x+i][y-i]+= value;// 副对角负方向
			}else {
				break;
			}
		}
	}
}
