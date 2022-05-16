package algorithms1_4;

import java.util.Scanner;

public class PawnAndHorse {
	public static long[][] chessboard;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int h1 = sc.nextInt();
		int h2 = sc.nextInt();
		sc.close();
		chessboard = new long[n+1][m+1];
		//�����Ŀ��Ƶ�
		chessboard[h1][h2] = -1;//horse
		try {chessboard[h1+2][h2+1] = -1;} catch(Exception e) {}
		try {chessboard[h1+1][h2+2] = -1;} catch(Exception e) {}
		try {chessboard[h1-1][h2+2] = -1;} catch(Exception e) {}
		try {chessboard[h1-2][h2+1] = -1;} catch(Exception e) {}
		try {chessboard[h1-2][h2-1] = -1;} catch(Exception e) {}
		try {chessboard[h1-1][h2-2] = -1;} catch(Exception e) {}
		try {chessboard[h1+1][h2-2] = -1;} catch(Exception e) {}
		try {chessboard[h1+2][h2-1] = -1;} catch(Exception e) {}
		// ��ʼ����
		chessboard[0][0] = 1;
		// ����ÿ�����
		long left = 0;
		long up = 0;
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < m+1; j++) {
				if(i == 0 && j == 0) {
					chessboard[i][j] = 1;
					continue;
				}
				if(chessboard[i][j] == -1) {
					continue;
				}
				if(i-1 < 0 || chessboard[i-1][j] == -1) {
					up = 0;
				}else {
					up = chessboard[i-1][j];
				}
				if(j-1 < 0 || chessboard[i][j-1] == -1) {
					left = 0;
				}else {
					left = chessboard[i][j-1];
				}
				chessboard[i][j] = up + left;
			}
		}
			
//		//�鿴�������
//		for(int i = 0; i < n+1; i++) {
//			for(int j = 0; j < m+1; j++) {
//				if(chessboard[i][j] < 0) {
//					System.out.print("-1");
//				}else {
//					System.out.print(" "+chessboard[i][j]);
//				}
//			}
//			System.out.println();
//		}

		//���
		System.out.println(chessboard[n][m]);
	}
}
