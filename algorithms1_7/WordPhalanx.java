package algorithms1_7;

import java.util.ArrayList;
import java.util.Scanner;

public class WordPhalanx {
	public static char[][] originMap;
	public static char[][] resultMap;
	public static char[] check = {'y','i','z','h','o','n','g'};
	public static int[] dx1= {-1,1,0,0,-1,1,1,-1};
	public static int[] dy1= {0,0,-1,1,-1,1,-1,1};
	public static ArrayList<Integer> startX = new ArrayList<>();
	public static ArrayList<Integer> startY = new ArrayList<>();
	public static int[] remeberX= new int [7];
	public static int[] remeberY= new int [7];
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		originMap = new char[n+1][n+1];
		resultMap = new char[n+1][n+1];
		String line;
		for(int i = 1; i <= n; i++) {
			line = sc.nextLine();
			for(int j = 0; j < n; j++) {
				if(line.charAt(j) == 'y') {
					startX.add(i);
					startY.add(j+1);
				}
				originMap[i][j+1] = line.charAt(j);
			}
		}
		sc.close();
//		for(int i = 0; i <= n; i++) {// 输入检查
//			for(int j = 0; j <= n; j++) {
//				System.out.print(" "+originMap[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i = 0; i < startX.size(); i++) {
//			System.out.println("startX="+startX.get(i)+"startY="+startY.get(i));
//		}
		int size = startX.size();
		for(int i = 0; i < size; i++) {// 遍历每个可能的起点
			for(int dir = 0; dir <= 7; dir++) {// 遍历八个方向
				search(0, startX.get(i),startY.get(i),dir);
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(resultMap[i][j] == '1') {
					System.out.print(originMap[i][j]);
				}else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}
	private static void search(int index, int x, int y, int dir) {
		if(originMap[x][y] == check[index]) {
			remeberX[index] = x;
			remeberY[index] = y;
			if(index == 6) {
				for(int i = 0; i < 7; i++) {
					resultMap[remeberX[i]][remeberY[i]] = '1';
				}
				return;
			}
			if(x+dx1[dir] >= 1 && y+dy1[dir] >= 1 
					&& x+dx1[dir] <= n && y+dy1[dir] <= n) {
				search(index+1,x+dx1[dir],y+dy1[dir],dir);
				}

		}
	}
}
