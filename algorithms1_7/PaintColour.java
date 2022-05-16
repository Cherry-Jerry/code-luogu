package algorithms1_7;

import java.util.LinkedList;
import java.util.Scanner;

public class PaintColour {
	public static void main(String[] args) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
 		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n+2][n+2];
		boolean[][] vis = new boolean[n+2][n+2];
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j+1] = sc.nextInt();
			}
		}
		sc.close();
//		for(int i = 0; i <= n; i++) {// 输入检查
//			for(int j = 0; j <=n; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i = 0; i <= n; i++) {// 输入检查
//			for(int j = 0; j <=n; j++) {
//				System.out.print(vis[i][j]);
//			}
//			System.out.println();
//		}
		int x;
		int y;
		LinkedList<Integer> queueX = new LinkedList<>();
		LinkedList<Integer> queueY = new LinkedList<>();
		// 自定边界[x/y = 0]必定在圈外，所以从（0,0）开始BFS搜索所有外部0
		vis[0][0] = true;
		queueX.add(0);
		queueY.add(0);
		while(!queueX.isEmpty()) {//把圈外的0全标记为-1
			x = queueX.removeFirst();
			y = queueY.removeFirst();
			for(int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX >= 0 && nextY >= 0 && nextX <= n && nextY <= n
						&& !vis[nextX][nextY] && map[nextX][nextY] == 0) {
					map[nextX][nextY] = -1;
					vis[nextX][nextY] = true;
					queueX.add(nextX);
					queueY.add(nextY);
				}
			}
		}
//		int startX = 0;
//		int startY = 0;
//		for(int i = 1; i <= n; i++) { // 全地图遍历寻找第一个圈内的0
//			for(int j = 1; j <=n; j++) {
//				if(map[i][j] == 0) {
//					startX = i;
//					startY = j;
//					break;
//				}
//			}
//			if(startX != 0 && startY != 0) {
//				break;
//			}
//		}
//		queueX.clear();
//		queueY.clear();
//		map[startX][startY] = 2;
//		vis[startX][startY] = true;
////		System.out.println("startX:"+startX+"startY:"+startY);
//		queueX.add(startX);
//		queueY.add(startY);
//		while(!queueX.isEmpty()) {//把圈内的0全标记为2
//			x = queueX.removeFirst();
//			y = queueY.removeFirst();
//			for(int i = 0; i < 4; i++) {
//				int nextX = x+dx[i];
//				int nextY = y+dy[i];
//				if(nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= n
//						&& !vis[nextX][nextY] && map[nextX][nextY] == 0) {
//					map[nextX][nextY] = 2;
//					vis[nextX][nextY] = true;
//					queueX.add(nextX);
//					queueY.add(nextY);
//				}
//			}
//		}
		for(int i = 1; i <= n; i++) {// 输出
			for(int j = 1; j <=n; j++) {
				if(map[i][j] == -1) {
					System.out.print("0 ");
				}else if(map[i][j] == 0) {
					System.out.print("2 ");
				}else {
					System.out.print("1 ");
				}
			}
			System.out.println();
		}		
	}
}
