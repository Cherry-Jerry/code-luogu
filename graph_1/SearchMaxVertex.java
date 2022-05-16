package graph_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SearchMaxVertex {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		ArrayList<LinkedList<Integer>> ends = new ArrayList<>();
		int[] in = new int[N+1];
		int[] out = new int[N+1];
		for(int i = 0; i <= N; i++) {
			ends.add(i,new LinkedList<Integer>());
		}
		int start,end;
		for(int i = 1; i <= M; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tokenizer.nextToken());
			end = Integer.parseInt(tokenizer.nextToken());
			ends.get(end).add(start);
			in[end]++;
			out[start]++;
		}
		int[] maxEnd = new int[N+1];
		for(int i = 1; i <= N; i++) {
			maxEnd[i] = i;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> starts = new LinkedList<>();
		for(int i = N; i >= 1; i--) {
				queue.add(i);
				while(!queue.isEmpty()) {
					end = queue.removeFirst();
					starts = ends.get(end);
					while(!starts.isEmpty()) {
						start = starts.removeFirst();
						if(maxEnd[end] > maxEnd[start]) {
							maxEnd[start] = maxEnd[end];
							queue.add(start);
						}
					}
				}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(maxEnd[i]+" ");
		}
	}
}
