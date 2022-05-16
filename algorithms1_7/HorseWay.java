package algorithms1_7;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
// BFS 可以用while循环+队列实现，避免了深度递归导致栈溢出
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class HorseWay {
	public static int[][] chessboard;
	public static LinkedList<Point> queue = new LinkedList<Point>();
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static int n;
	public static int m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		chessboard = new int[n+1][m+1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				chessboard[i][j] = Integer.MAX_VALUE;
			}
		}
		chessboard[x][y] = 0;
		queue.add(new Point(x,y));
		
		while(!queue.isEmpty()) {
			Point point = queue.removeFirst();
			// 八个坐标可用数组优化 x[i] y[i];
			int xss = point.x-2;
			int xs = point.x-1;
			int xpp = point.x+2;
			int xp = point.x+1;
			int yss = point.y-2;
			int ys = point.y-1;
			int ypp = point.y+2;
			int yp = point.y+1;
			
			if(xss >= 1 && yp <= m) {//1
				if(chessboard[point.x][point.y]+1 < chessboard[xss][yp]) {
					chessboard[xss][yp] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xss,yp));
				}
			}
			if(xs >= 1 && ypp <= m) {//2
				if(chessboard[point.x][point.y]+1 < chessboard[xs][ypp]) {
					chessboard[xs][ypp] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xs,ypp));
				}
			}
			if(xp <= n && ypp <= m) {//3
				if(chessboard[point.x][point.y]+1 < chessboard[xp][ypp]) {
					chessboard[xp][ypp] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xp,ypp));
				}
			}
			if(xpp <= n && yp <= m) {//4
				if(chessboard[point.x][point.y]+1 < chessboard[xpp][yp]) {
					chessboard[xpp][yp] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xpp,yp));
				}
			}
			if(xpp <= n && ys >= 1) {//5
				if(chessboard[point.x][point.y]+1 < chessboard[xpp][ys]) {
					chessboard[xpp][ys] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xpp,ys));
				}
			}
			if(xp <= n && yss >= 1) {//6
				if(chessboard[point.x][point.y]+1 < chessboard[xp][yss]) {
					chessboard[xp][yss] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xp,yss));
				}
			}
			if(xs >= 1 && yss >= 1) {//7
				if(chessboard[point.x][point.y]+1 < chessboard[xs][yss]) {
					chessboard[xs][yss] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xs,yss));
				}
			}
			if(xss >= 1 && ys >= 1) {//8
				if(chessboard[point.x][point.y]+1 < chessboard[xss][ys]) {
					chessboard[xss][ys] = chessboard[point.x][point.y]+1;
					queue.add(new Point(xss,ys));
				}
			}
		}
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= m; ++j) {
				if(chessboard[i][j] == Integer.MAX_VALUE) {
					out.print("-1   "); 
				}else if(chessboard[i][j] < 10) {
					out.print(chessboard[i][j]+"    "); 
				}else if(chessboard[i][j] < 100) {
					out.print(chessboard[i][j]+"   "); 
				}else if(chessboard[i][j] < 1000) {
					out.print(chessboard[i][j]+"  "); 
				}else if(chessboard[i][j] < 10000) {
					out.print(chessboard[i][j]+" "); 
				}else {
					out.print(chessboard[i][j]); 
				}
			}
			out.print("\n");
			out.flush();
		}
	}
}
