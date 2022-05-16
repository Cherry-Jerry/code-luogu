package graph_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;import java.util.LinkedList;
import java.util.StringTokenizer;

public class Chores {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int[] sum = new int[n+1];
		int[] len = new int[n+1];
		int[] in = new int[n+1];
		int[] out = new int[n+1];
		ArrayList<LinkedList<Integer>> starts = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			starts.add(i,new LinkedList<Integer>());
		}
		int front;
		LinkedList<Integer> ends;
		for(int i = 1; i<= n; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			if(i == Integer.parseInt(tokenizer.nextToken())) {
				 sum[i] = len[i] = Integer.parseInt(tokenizer.nextToken());
				 ends = starts.get(i);
				while((front = Integer.parseInt(tokenizer.nextToken())) != 0) {
					out[i]++;
					in[front]++;
					ends.add(front);
				}
			}else {
				System.out.println("error");
			}
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(in[i] == 0) {
				queue.add(i);
			}
		}
		int start,end;
		while(!queue.isEmpty()) {
			start = queue.removeFirst();
			ends = starts.get(start);
			while(!ends.isEmpty()) {
				end = ends.removeFirst();
				sum[end] = Math.max(sum[end], sum[start]+len[end]);
				if(--in[end] == 0) {
					queue.add(end);
				}
			}
		}
		int maxIndex = 0;
		for(int i = 1; i <= n; i++) {
			if(sum[maxIndex] < sum[i]) {
				maxIndex = i;
			}
		}
		System.out.println(sum[maxIndex]);
	}
}
