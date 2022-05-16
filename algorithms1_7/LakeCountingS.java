package algorithms1_7;

import java.util.LinkedList;
import java.util.Scanner;

public class LakeCountingS {
	public static int N;
	public static int M;
	public static int counter = 0;
	public static char[][] map;
	public static int[][] mark;
	public static int[] dx = {-1,1,0,0,-1,-1,1,1};
	public static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) {
		LinkedList<Integer> queueX = new LinkedList<>(); 
		LinkedList<Integer> queueY = new LinkedList<>(); 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N+1][M+1];
		mark = new int[N+1][M+1];
		String line;
		for(int i = 1; i <= N; ++i) {
			line = sc.nextLine();
			for(int j = 0; j < M; ++j) {
				map[i][j+1] = line.charAt(j);
				if(map[i][j+1] == 'W') {
					queueX.add(i);
					queueY.add(j+1);
				}
			}
		}
		sc.close();
		queueX.add(1);
		queueY.add(1);
		int x;
		int y;
		while(!queueX.isEmpty()) { // 找湖
			x = queueX.removeFirst();
			y = queueY.removeFirst();
			if(map[x][y] == 'W' && mark[x][y] == 0) {
				counter++;
				markLake(x,y);
			}		
		}
//		System.out.println("=========mark=========");
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= M; j++) {
//				System.out.print(" "+mark[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(counter);
	}
	private static void markLake(int startX, int startY) {
		boolean[][] vis = new boolean[N+1][M+1];
		for(int i = 0; i <= N; i++) {
			vis[i][0] = true;
		}
		for(int i = 0; i <= M; i++) {
			vis[0][i] = true;
		}
		LinkedList<Integer> queueX = new LinkedList<>(); 
		LinkedList<Integer> queueY = new LinkedList<>();
		vis[startX][startY] = true;
		queueX.add(startX);
		queueY.add(startY);
		int x;
		int y;
		while(!queueX.isEmpty()) { //BFS 填湖
			x = queueX.removeFirst();
			y = queueY.removeFirst();
//			vis[x][y] =true;    低效率
			mark[x][y] = counter;
			for(int i = 0; i < 8; i++) {
				if(x+dx[i] >= 1 && y+dy[i] >= 1 && x+dx[i] <= N && y+dy[i] <= M
						&& map[x+dx[i]][y+dy[i]] == 'W'
						&& !vis[x+dx[i]][y+dy[i]]) {
					vis[x+dx[i]][y+dy[i]] =true; // 高效率 
					queueX.add(x+dx[i]);
					queueY.add(y+dy[i]);
				}
			}
			System.out.println("size of queue:"+queueX.size());
		}

	}

}
