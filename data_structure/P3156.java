package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3156 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m  = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n+1];
		tokenizer = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			a[i] =  Integer.parseInt(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(br.readLine());
		int x;
		for(int i =1; i <= m ;i++) {
			x = Integer.parseInt(tokenizer.nextToken());
			System.out.println(a[x]);
		}
	}
}
