package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1160 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] operations = new String[N];
		for(int i = 0; i < N-1; i++) {
			operations[i] = br.readLine();
		}
		ArrayList<LinkedList<Integer>> array = new ArrayList<>();
		LinkedList<Integer> list;
		for(int i = 0; i <= N; i++) {
			list = new LinkedList<Integer>();
			list.add(i);
			array.add(list);
		}
		StringTokenizer tokenizer;
		int index,toward;
		for(int i = N; i >= 2; i--) {
			tokenizer = new StringTokenizer(operations[i-2]);
			index = Integer.parseInt(tokenizer.nextToken());
			toward = Integer.parseInt(tokenizer.nextToken());
			if(toward == 0) {
				array.get(index).addAll(0,array.get(i));
			}else {
				array.get(index).addAll(array.get(i));
			}
		}
		int M = Integer.parseInt(br.readLine());
		boolean[] deleted = new boolean[N+1];
		for(int i = 1; i <= M; i++) {
			deleted[Integer.parseInt(br.readLine())] = true;
		}
		
		list = array.get(1);
		int num;
		for(int i = 0; i < N; i++) {
			num = list.removeFirst();
			if(!deleted[num]) {
				System.out.print(num+" ");
			}
		}
		
	}
}
