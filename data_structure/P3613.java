package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P3613 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int q  = Integer.parseInt(tokenizer.nextToken());
		
		ArrayList<HashMap<Integer,Integer>> a = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			a.add(new HashMap<>(0));
		}
		
		int flag = 0;
		for(int i = 1; i <= q; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			flag = Integer.parseInt(tokenizer.nextToken());
			if (flag == 1) {
				a.get(Integer.parseInt(tokenizer.nextToken())).put(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
			}
			if (flag == 2) {
				System.out.println(a.get(Integer.parseInt(tokenizer.nextToken())).get(Integer.parseInt(tokenizer.nextToken())));
			}

		}
 	}
}
