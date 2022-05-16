package algorithms1_4;

import java.util.Scanner;
public class SpecialNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] memory = new int[n+1];
		memory[0] = 1;
		memory[1] = 1;
		for(int i = 2; i <= n; i++) {
			if(i % 2 == 0) {
				memory[i] = memory[i-1]+memory[i/2];
			}
			if(i % 2 == 1) {
				memory[i] = memory[i-1];
			}
		}
		System.out.println(memory[n]);
	}
}
// ͨ�������ݹ����n��С�Ĵ𰸣�
/*
n:0 ans:1
n:1 ans:1
n:2 ans:2
n:3 ans:2
n:4 ans:4
n:5 ans:4
n:6 ans:6
n:7 ans:6
n:8 ans:10
n:9 ans:10
n:10 ans:14
n:11 ans:14
n:12 ans:20
n:13 ans:20
n:14 ans:26
n:15 ans:26
n:16 ans:36
n:17 ans:36
n:18 ans:46
n:19 ans:46
n:20 ans:60
*/
//�ҵ��𰸺�����Ĺ�ϵ���Լ����ƹ�ʽ
//��n������ʱ��f(n) = f(n-1)
//��n��ż��ʱ��f(n) = f(n-1)+f(n/2)


//�����ݹ����
//public class SpecialNumber {
//	public static int counter;
//	public static StringBuilder sb = new StringBuilder();
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		long n = sc.nextLong();
//		sc.close();
//		for(int i = 0; i <= n; i++) {
//			counter = 0;
//			count(i,i);
//			System.out.print("n:"+i+" ");
//			System.out.println("ans:"+counter);
//		}
//
//
//	}
//	// num����ǰ�����֣�add �����������ƴ�ӵ�����
//	private static void count(long num, long add) {
//		counter++;
//		if(add <= 1) {
//			return;
//		}
//		for(long i = 1; i <= Math.min(num,add/2); i++) {
//			count(Long.parseLong(i+""+num),i);
//		}
//	}
//
//}
