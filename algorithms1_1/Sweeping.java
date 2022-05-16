package algorithms1_1;

import java.io.IOException;
import java.util.Scanner;

public class Sweeping {
	public static void main(String[] args) throws IOException {
		

		
		
		long startTime, endTime;
		startTime=System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] blocks = new char[n+2][m+2];
		int[][] result = new int[n+2][m+2];



		String line = null;
		char[] charArray;
		for(int i = 1; sc.hasNextLine(); i++) {
			line = sc.nextLine();
			if("".equals(line)) break;
			charArray = line.toCharArray();
			for(int j = 1; j<m+1; j++) {
				if(charArray[j-1] == '?' || charArray[j-1] == '*') {
					blocks[i][j] = charArray[j-1];
				} else {
					j--;
				}
			}
		}
		endTime=System.currentTimeMillis();
		System.out.println("读入时间： "+(endTime-startTime)+"ms");
		
		
		startTime=System.nanoTime();
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<m+1; j++) {
				if(blocks[i][j] == '*')  {
					result[i][j] = -1;
				}else {
					if(blocks[i-1][j-1] == '*')  result[i][j]++;
					if(blocks[i-1][j] == '*')  result[i][j]++;
					if(blocks[i-1][j+1] == '*')  result[i][j]++;
					if(blocks[i][j-1] == '*')  result[i][j]++;
					if(blocks[i][j+1] == '*')  result[i][j]++;
					if(blocks[i+1][j-1] == '*')  result[i][j]++;
					if(blocks[i+1][j] == '*')  result[i][j]++;
					if(blocks[i+1][j+1] == '*')  result[i][j]++;
				}
			}
		}
		endTime=System.nanoTime();
		System.out.println("搜索周围格子时间： "+(endTime-startTime)+"ns");
		
		
		
		startTime=System.nanoTime();
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<m+1; j++) {
				if(result[i][j] == -1) {
					System.out.print('*');
				}else {
					System.out.print(result[i][j]);
				}
			}
			System.out.print('\n');
		}
		endTime=System.nanoTime();
		System.out.println("输出时间： "+(endTime-startTime)+"ns");
		sc.close();
	}

}
