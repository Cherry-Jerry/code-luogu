package algorithms1_3;

import java.util.Scanner;


// 把题目分成两个集合C1，C2，计算集合分别耗时取最大值
// 搜索回溯算法实现 遍历二分集合，复杂度O(2^n)
public class PassExams{
	public static int[][] a = new int[5][21];
	public static int[] s = new int[5];
	public static int sumTime = 0;
	public static int minTime;
	public static int left,right;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 4; i++) {
			s[i] = sc.nextInt();
		}
		for(int i = 1; i <=4; i++) {
			for(int j = 1; j <=s [i]; j++) {
				a[i][j] = sc.nextInt();
			}
			minTime = Integer.MAX_VALUE;
			left = 0; 
			right = 0;
			search(i,1);
			sumTime += minTime;
		}
		sc.close();
		System.out.println(sumTime);
		
	}
	private static void search(int i, int index) {
		if(index > s[i]) {
			minTime = Math.min(minTime, Math.max(left, right));
			return;
		}
		left += a[i][index];
		search(i,index+1);
		left -= a[i][index];
		right += a[i][index];
		search(i,index+1);
		right -= a[i][index];
	}
}
/*  全排列的时间复杂度是  O(N!)
public class PassExams {
	public static int[] result;
	public static LinkedList<Integer> queue = new LinkedList<>();
	public static boolean[] using;
	public static int minTime;
	public static int sumTime = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		int s4 = sc.nextInt();
		int[] A = new int[s1];
		int[] B = new int[s2];
		int[] C = new int[s3];
		int[] D = new int[s4];
		
		for(int i = 0; i < s1; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0; i < s2; i++) {
			B[i] = sc.nextInt();
		}
		for(int i = 0; i < s3; i++) {
			C[i] = sc.nextInt();
		}
		for(int i = 0; i < s4; i++) {
			D[i] = sc.nextInt();
		}
		sc.close();
	
		minTime  = Integer.MAX_VALUE;
		result = new int[A.length];
		using = new boolean[A.length];
		dfs(A,0);
		sumTime += minTime;
		
		minTime  = Integer.MAX_VALUE;
		result = new int[B.length];
		using = new boolean[B.length];
		dfs(B,0);
		sumTime += minTime;
		
		minTime  = Integer.MAX_VALUE;
		result = new int[C.length];
		using = new boolean[C.length];
		dfs(C,0);
		sumTime += minTime;
		
		minTime  = Integer.MAX_VALUE;
		result = new int[D.length];
		using = new boolean[D.length];
		dfs(D,0);
		sumTime += minTime;
		
		System.out.println(sumTime);
	}
	private static void dfs(int[]array, int index) { 
		if(index >= array.length) {
			int time = 0;
			int leftBrain = 0;
			int rightBrain = 0;
			int rest = 0;
			for(int i = 0; i < array.length;i++) {
				queue.add(array[result[i]]);
			}
			while(!queue.isEmpty()) {
				if(leftBrain == 0) {
					leftBrain = queue.remove();
				}
				if(rightBrain == 0 && !queue.isEmpty()) {
					rightBrain = queue.remove();
				}
				rest = leftBrain - rightBrain;
				if(rest >= 0) {
					time += rightBrain;
					leftBrain = rest;
					rightBrain = 0;
				}else {
					time += leftBrain;
					rightBrain = -rest;
					leftBrain = 0;
				}
				if(time >= minTime) {
					return;
				}
			}
			time += leftBrain;
			time += rightBrain;
			
			if(time < minTime) {
				minTime =time;
			}
			return;
		}
		for(int i = 0; i < array.length; i++){
			if(!using[i]) {
				using[i] = true;
				result[index] = i;
				dfs(array,index+1);
				using[i] = false;
			}
		}
	}

}
*/
