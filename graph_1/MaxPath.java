package graph_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 考虑冲出负边，考虑非联通
// 难点：更新节点路径的并入队的条件，45-50行
// 第一次出错：没有注意顶点不同边
public class MaxPath {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		int[][] connect = new int[n+1][n+1];
		int[] maxPath = new int[n+1];//1--->n
		for(int i = 0; i <= n; i++) {
			maxPath[i] = Integer.MAX_VALUE;
		}
		maxPath[1] = 0;
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				connect[i][j] =Integer.MAX_VALUE;
			}
		}
		int start,end;
		for(int i = 1; i <= m; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tokenizer.nextToken());
			end = Integer.parseInt(tokenizer.nextToken());
			if(connect[start][end] == Integer.MAX_VALUE) {
				connect[start][end] = Integer.parseInt(tokenizer.nextToken());
			}else {
				connect[start][end]= Math.max(connect[start][end],
						Integer.parseInt(tokenizer.nextToken()));
			}

		}
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()) {
			start = queue.removeFirst();
			for(int i = 1; i <= n; i++) {
				if(connect[start][i] != Integer.MAX_VALUE) {
					if(maxPath[i] == Integer.MAX_VALUE 
							|| connect[start][i] < 0 
							|| maxPath[i] < maxPath[start]+connect[start][i]) {
						maxPath[i] = maxPath[start]+connect[start][i]; 
						queue.add(i);
					}
				}
			}
		}
		if(maxPath[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(maxPath[n]);
		}
	}
}
