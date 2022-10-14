package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1540 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());
		LinkedList<Integer> memory = new LinkedList<>();
		
		int search = 0;
		int word;
		tokenizer = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			word = Integer.parseInt(tokenizer.nextToken());
			if(!memory.contains(word)) {
				search++;
				if(memory.size() < M) {
					memory.add(word);
				}else {
					memory.removeFirst();
					memory.add(word);
				}
			}
		}
		sc.close();
		System.out.println(search);
	}

}
