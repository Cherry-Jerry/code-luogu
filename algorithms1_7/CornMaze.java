package algorithms1_7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * BFS 搜索，读入时候标记传送门，搜索到传送门时候，进行坐标转移
 * @author 10634  //20:46
 *
 */
class Gate{
	int X1;
	int Y1;
	int X2;
	int Y2;
}
public class CornMaze {
	public static void main(String[] args) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		HashMap<Character,Gate> gates = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int startX = 0;
		int startY = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[N+1][M+1];
		String line;
		for(int i = 1; i <= N; i++) {
			line = sc.nextLine();
			for(int j = 0; j < M; j++) {
				if(line.charAt(j) == '@') {
					startX = i;
					startY =j+1;
				}else if('A' <= line.charAt(j) && line.charAt(j) <= 'Z') {
					if(gates.get(line.charAt(j)) == null) {
						Gate gate = new Gate();
						gate.X1 = i;
						gate.Y1 = j+1;
						gate.X2 = i;
						gate.Y2 = j+1;
						gates.put(line.charAt(j), gate);
					}else {
						Gate gate = gates.get(line.charAt(j));
						gate.X2 = i;
						gate.Y2 = j+1;
					}
				}
				map[i][j+1] = line.charAt(j);
			}
		}
		sc.close();
//		for(int i = 0; i <= N; i++) { //输出检查
//			for(int j = 0; j <= M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		Gate gatee = gates.get('X');
//		System.out.println("fromX:"+gatee.X1+"fromY:"+gatee.Y1+"toX:"+gatee.X2+"toY:"+gatee.Y2);
//		System.out.println("startX:" +startX+"startY"+startY);
		LinkedList<Integer> queueX = new LinkedList<Integer>();
		LinkedList<Integer> queueY = new LinkedList<Integer>();
		int[][] stepMap = new int[N+1][M+1];
		for(int i = 0; i <= N; i++) { 
			for(int j = 0; j <= M; j++) {
				stepMap[i][j] = Integer.MAX_VALUE;
			} 
		}
		
		boolean[][] vis = new boolean[N+1][M+1];
		stepMap[startX][startY] = 0;
		vis[startX][startY] = true;
		queueX.add(startX);
		queueY.add(startY);
		int x = 0,y = 0;
		int nextX,nextY;
		while(!queueX.isEmpty()) {
			x = queueX.removeFirst();
			y = queueY.removeFirst();
			if(map[x][y] == '=') {
				break;
			}
			for(int i = 0; i < 4; i++) {
				nextX = x+dx[i];
				nextY = y+dy[i];
				if(!vis[nextX][nextY] || stepMap[nextX][nextY] > stepMap[x][y]+1) {
					if(map[nextX][nextY] == '.' || map[nextX][nextY] == '=') {
						vis[nextX][nextY] = true;
						stepMap[nextX][nextY] = stepMap[x][y]+1;
						queueX.add(nextX);
						queueY.add(nextY);
					}
					if('A' <= map[nextX][nextY] && map[nextX][nextY] <= 'Z') {
						vis[nextX][nextY] = true;
						stepMap[nextX][nextY] = stepMap[x][y]+1;
						Gate gate = gates.get(map[nextX][nextY]);
						if(gate.X1 == nextX && gate.Y1 == nextY) {
							stepMap[gate.X2][gate.Y2] = stepMap[x][y]+1;
							queueX.add(gate.X2);
							queueY.add(gate.Y2);
						}else {
							stepMap[gate.X1][gate.Y1] = stepMap[x][y]+1;
							queueX.add(gate.X1);
							queueY.add(gate.Y1);
						}
					}
				}
			}
		}
//		for(int i = 0; i <= N; i++) { 
//			for(int j = 0; j <= M; j++) {
//				System.out.print(" "+map[i][j]);
//				}
//			System.out.println();
//			}
//
//		for(int i = 0; i <= N; i++) { 
//			for(int j = 0; j <= M; j++) {
//				if(stepMap[i][j] == Integer.MAX_VALUE) {
//					System.out.print(" ?");
//				}else {
//					if(stepMap[i][j] < 10) {
//						System.out.print(" "+stepMap[i][j]);
//					}else {
//						System.out.print(stepMap[i][j]);
//					}
//				}
//				
//			}
//			System.out.println();
//		}
		System.out.println(stepMap[x][y]);
	}
}
