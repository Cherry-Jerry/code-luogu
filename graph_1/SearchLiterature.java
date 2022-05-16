package graph_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 图的储存方法,链式向前星，vector
 * @author 10634
 *
 */

public class SearchLiterature {
	public static HashMap<Integer,LinkedList<Integer>> graph;
	public static int n;
	public static int m;
	public static boolean[] finished;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
//		graph = new ArrayList<>();
//		for(int i = 0; i <= n; i++) {
//			graph.add(i, new LinkedList<>());
//		}
		graph = new HashMap<Integer,LinkedList<Integer>>();
		int start,end;
		for(int i = 1; i <= m; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			start = Integer.parseInt(tokenizer.nextToken());
			end = Integer.parseInt(tokenizer.nextToken());
			if(graph.get(start) == null) {
				graph.put(start, new LinkedList<>());
			}
			graph.get(start).add(end);
		}
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		};
		LinkedList<Integer> list;
		for(int i = 1; i <= n; i++) {
			list = graph.get(i);
			if(list != null) {
				list.sort(comparator);
			}
		}

		finished = new boolean[n+1];
		dfs(1);
		System.out.println();
		for(int i = 1; i <= n; i ++) {
			finished[i] = false;
		}
		LinkedList<Integer> queue  = new LinkedList<>();
		finished[1] = true;
		System.out.print(1+" ");
		queue.add(1);
		int index,next;
		while(!queue.isEmpty()) {
			index = queue.removeFirst();
			list = graph.get(index);
			if(list == null) {
				continue;
			}else {
				Iterator<Integer> iter = list.iterator();
				while(iter.hasNext()) {
					next = iter.next();
					if(!finished[next]) {
						finished[next] = true;
						System.out.print(next+" ");
						queue.add(next);
					}
				}
			}
		}
	}
	private static void dfs(int index) {
		finished[index] = true;
		System.out.print(index+" ");
		LinkedList<Integer> list = graph.get(index);
		if(list == null) {
			return;
		}else {
			int next;
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()) {
				next = iter.next();
				if(!finished[next]) {
					dfs(next);
				}
			}
		}
	}
}
