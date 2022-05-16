package algorithms1_7;

import java.util.LinkedList;
//import java.util.Random;
import java.util.Scanner;

/**
 * 这道题做了一天。
 * 第一次出错在方法。使用了模拟法，先降落陨石，人再移动，导致代码极其复杂，不容易debug，容易出错
 * 第二次出错在写BFS时没有设定vis[x][y]标记已访问的数组，导致某些点反复被访问，队列heap溢出
 * 此外获得一些经验，
 * 比如BFS地图要初始化，未访问的点设置距离为无穷大（Integer.MAX_VALUE）
 * 比如遍历的嵌套，陨石下落M次和时间流失T和处理队列（!queue.isEmpty）,相互交织，容易多出、缺少某种情况
 * 比如使用Random 测试程序
 * 
 * @author 10634
 *
 */

public class MeteorShower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int[] dx = {0,-1,1,0,0};
		int[] dy = {0,0,0,-1,1};
		int[][] meteorMap = new int[302][302];
		int[][] personMap = new int [302][302];
		boolean[][] vis = new boolean[302][302];
		for(int i = 0; i < 302;++i) {
			for(int j = 0; j < 302;++j) {
				meteorMap[i][j] = Integer.MAX_VALUE;
				personMap[i][j] = Integer.MAX_VALUE;
			}
		}
		int x;
		int y;
		int t;
//		Random random = new Random();
		for(int i = 0; i < M; ++i) {
			x = sc.nextInt();
			y = sc.nextInt();
			t = sc.nextInt();
//			x = random.nextInt(101);
//			y = random.nextInt(101);
//			t = random.nextInt(501);
//			System.out.println(x+" "+y+" "+t);
			for(int j = 0; j < 5; ++j) {
				if(x+dx[j] >= 0 && y+dy[j]>= 0) {
					meteorMap[x+dx[j]][y+dy[j]] 
							= Math.min(t, meteorMap[x+dx[j]][y+dy[j]]);
				}
			}
		}
		sc.close();

		int answer = -1;
		LinkedList<Integer> queueX = new LinkedList<>();
		LinkedList<Integer> queueY = new LinkedList<>();
		queueX.add(0);
		queueY.add(0);
		personMap[0][0] = 0;
		vis[0][0] = true;
		while(!queueX.isEmpty()) {
			int X  = queueX.removeFirst();
			int Y  = queueY.removeFirst();
//			System.out.println("serach X="+X+" Y="+Y);
			if(meteorMap[X][Y] == Integer.MAX_VALUE) {
				answer = personMap[X][Y];
				break;
			}
			for(int j = 1; j < 5; ++j) {
				x = X+dx[j];
				y = Y+dy[j];
				if(x >= 0 && y >= 0 && !vis[x][y] && personMap[X][Y]+1 < meteorMap[x][y]) {
					queueX.add(x);
					queueY.add(y);
					personMap[x][y] = personMap[X][Y]+1;
					vis[x][y] =true;
				}
			}
		}
		
		
//		for(int i = 0; i < 50; ++i) {
//			for(int j = 0; j < 50; ++j) {
//				if(meteorMap[i][j] != Integer.MAX_VALUE) {
//					System.out.print(" "+meteorMap[i][j]);
//				}else {
//					System.out.print(" X");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("==========================");
//		for(int i = 0; i < 50; ++i) {
//			for(int j = 0; j < 50; ++j) {
//				if(personMap[i][j] != Integer.MAX_VALUE) {
//					System.out.print(" "+personMap[i][j]);
//				}else {
//					System.out.print(" X");
//				}
//			}
//			System.out.println();
//		}
		
		System.out.println(answer);
	}
}
