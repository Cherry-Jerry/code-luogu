package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SplicingNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(br.readLine());
		String[] a = new String[n];
		for(int i = 0; i < n; i++) {
			a[i] = tokenizer.nextToken();
		}
		String tmp;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-1-i; j++) {
				if((a[j]+a[j+1]).compareTo(a[j+1]+a[j]) < 0) {
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(a[i]);
		}
		
	}

}
