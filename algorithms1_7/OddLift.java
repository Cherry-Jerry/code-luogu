package algorithms1_7;

import java.util.Scanner;
// 01dfs x
// �� BFS Ч�ʸ��� "�ѵ��������Ž�"
public class OddLift {
	public static int N;
	public static int B;
	public static int[] K;
	public static boolean[] vis;
	public static int shortWay = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int A = sc.nextInt();
		B = sc.nextInt();
		K = new int[N+1];
		vis = new boolean[N+1];
		for(int i = 1; i <= N; ++i) {
			K[i] = sc.nextInt();
		}
		sc.close();
			dfs(A,0);
			if(shortWay != Integer.MAX_VALUE) {
				System.out.println(shortWay);
			}else {
				System.out.println("-1");
			}
	}
	// sum ����¼�������ϣ����ǵݹ���������ٵݹ�������ģ�vis[index]��ֹ����ѭ�����
	// sum  > shortWay ��֦����
	private static void dfs(int index, int sum) {
		if(sum > shortWay || index == B) {
			shortWay = Math.min(shortWay,sum);
			return;
		}
		vis[index] = true;
		if(index+K[index] <= N && !vis[index+K[index]]) {
			dfs(index+K[index],sum+1);
		}
		if(index-K[index] >= 1 && !vis[index-K[index]]) {
			dfs(index-K[index],sum+1);
		}
		vis[index] = false;
	}
}
