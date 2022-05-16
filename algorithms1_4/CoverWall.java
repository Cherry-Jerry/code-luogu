package algorithms1_4;

import java.util.Scanner;

public class CoverWall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int[] answer = new int[1000000+1];
		answer[0] = -1;
		answer[1] = 1;
		answer[2] = 2;
		answer[3] = 5;
		for(int i = 4; i <= N; i++) {
			answer[i] = 2*answer[i-1]+answer[i-3];
			if(answer[i] > 100000) {
				answer[i] %= 100000; 
			}
		}
		String target =  String.valueOf(answer[N]);
		if(target.length() <= 4) {
			System.out.println(target);
		}else {
			System.out.println(target.substring(target.length()-4));
		}
		
	}
}
//public class CoverWall {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		sc.close();
//		ArrayList<BigInteger> answer = new ArrayList<BigInteger>();
//		answer.add(0, null);
//		answer.add(1,new BigInteger("1"));
//		answer.add(2,new BigInteger("2"));
//		answer.add(3,new BigInteger("5"));
//		BigInteger two = new BigInteger("2");
//		for(int i = 4; i <= N; i++) {
//			answer.add(i,answer.get(i-1).multiply(two).add(answer.get(i-3)));
//		}
//		String target = answer.get(N).toString();
//		if(target.length() <= 4) {
//			System.out.println(target);
//		}else {
//			System.out.println(target.substring(target.length()-4));
//		}
//		
//	}
//}
// 先用模拟法，求简单结果，找递推关系F[N] = 2*F[N-1] +F[N-3];
/*
N:1  counter:1
N:2  counter:2
N:3  counter:5
N:4  counter:11
N:5  counter:24
N:6  counter:53
N:7  counter:117
N:8  counter:258
N:9  counter:569
N:10  counter:1255
N:11  counter:2768
N:12  counter:6105
N:13  counter:13465
N:14  counter:29698
N:15  counter:65501
 */
//public class CoverWall {
//	public static int[][] wall;
//	public static int N;
//	public static int counter = 0; //need to be BigInteger
//	public static int brick = 0; //need to be BigInteger
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		sc.close();
//		for(int i = 1; i <= 15;i++) {
//			counter =0;
//			N = i;
//			wall = new int[3][N+1];
//			bricking(1);
//			System.out.println("N:"+N+"  counter:"+counter);
//		}
//	}
//
//	private static void bricking(int index) {
//		if(index > N) {
////			System.out.println();
////			for(int i = 1; i <= N; ++i) {
////				System.out.print(wall[1][i]);
////			}
////			System.out.println();
////			for(int i = 1; i <= N; ++i) {
////				System.out.print(wall[2][i]);
////			}
////			System.out.println();
//			counter++;
//			return;
//		}
//		if(wall[1][index] == 0 && wall[2][index] == 0) {
//			//情况1
//			brick++;
//			wall[1][index] =brick;
//			wall[2][index] =brick;
//			bricking(index+1);
//			brick--;
//			wall[1][index] =0;
//			wall[2][index] =0;
//			//index < length - 2
//			if(index < N) {
//				//情况2
//				brick++;
//				wall[1][index] =brick;
//				wall[2][index] =brick;
//				wall[2][index+1] =brick;
//				bricking(index+1);
//				brick--;
//				wall[1][index] =0;
//				wall[2][index] =0;
//				wall[2][index+1] =0;
//				//情况3
//				brick++;
//				wall[1][index] =brick;
//				wall[1][index+1] =brick;
//				wall[2][index] =brick;
//				bricking(index+1);
//				brick--;
//				wall[1][index] =0;
//				wall[1][index+1] =0;
//				wall[2][index] =0;
//				//情况4
//				brick++;
//				wall[1][index] =brick;
//				wall[1][index+1] =brick;
//				brick++;
//				wall[2][index] =brick;
//				wall[2][index+1] =brick;
//				bricking(index+2);
//				brick--;
//				wall[2][index] =0;
//				wall[2][index+1] =0;
//				brick--;
//				wall[1][index] =0;
//				wall[1][index+1] =0;
//			}else {
//				return;
//			}
//		}
//		if(wall[1][index] == 0 && wall[2][index] != 0) {
//			if(index < N) {
//				//情况1
//				brick++;
//				wall[1][index] = brick;
//				wall[1][index+1] = brick;
//				bricking(index+1);
//				brick--;
//				wall[1][index] = 0;
//				wall[1][index+1] = 0;
//				//情况2
//				brick++;
//				wall[1][index] = brick;
//				wall[1][index+1] = brick;
//				wall[2][index+1] = brick;
//				bricking(index+2);
//				brick--;
//				wall[1][index] = 0;
//				wall[1][index+1] = 0;
//				wall[2][index+1] = 0;
//			}else {
//				return;
//			}
//		}
//		if(wall[1][index] != 0 && wall[2][index] == 0) {
//			if(index < N) {
//				//情况1
//				brick++;
//				wall[2][index] = brick;
//				wall[2][index+1] = brick;
//				bricking(index+1);
//				brick--;
//				wall[2][index] = 0;
//				wall[2][index+1] = 0;
//				//情况2
//				brick++;
//				wall[2][index] = brick;
//				wall[2][index+1] = brick;
//				wall[1][index+1] = brick;
//				bricking(index+2);
//				brick--;
//				wall[2][index] = 0;
//				wall[2][index+1] = 0;
//				wall[1][index+1] = 0;
//			}else {
//				return;
//			}
//		}
//	}
//}
