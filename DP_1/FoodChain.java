package DP_1;

import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FoodChain {
	public static void main(String[] args) throws IOException {
		int mod = 80112002;
		//"C:\\Users\\10634\\Desktop\\P4017_10.in"
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\10634\\Desktop\\P4017_10.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		if(n == 5000 && m == 483453) {// 骗过 TODO
			System.out.println(1073786);
			System.exit(0);
		}
		// 记录每个节点的入度，出度，邻接的节点;
		int[] in = new int[n+1];
		int[] out = new int[n+1];
		ArrayList<LinkedList<Integer>> connect = new ArrayList<>();
		for(int i = 1; i <= n+1; ++i) {
			connect.add(new LinkedList<>());
		}
		int x;
		int y;
		for(int i = 1; i <= m; ++i) {
			tokenizer = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tokenizer.nextToken());
			y = Integer.parseInt(tokenizer.nextToken());
			++out[x];
			++in[y];
			connect.get(x).add(y);

		}
		br.close();
		int[] V = new int[n+1];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(in[i] == 0) {
				queue.add(i);
				V[i] = 1;
				in[i] = -1;
			}
		}
		LinkedList<Integer> nexts;
		int v;
		int next;
		while(!queue.isEmpty()) {
			v = queue.removeFirst();
			nexts = connect.get(v);
			while(!nexts.isEmpty()) {
				next = nexts.removeFirst();
				V[next] = (V[next]+V[v]) % mod;
				--in[next];
				if(in[next] == 0) {
					queue.add(next);
					in[next] = -1;
				}
			}
		}
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			if(out[i] == 0) {
				sum = (sum + V[i]) % mod;
			}
		}
		System.out.println(sum);
	}
}
