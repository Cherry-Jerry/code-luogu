package algorithms1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PaintFlag {
	public static int minCounter = Integer.MAX_VALUE;
	public static int counter = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		ArrayList<String> strings = new ArrayList<String>();
		for(int i = 0; i < N; i++) {
			strings.add(br.readLine());
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println("str["+i+"]:"+ strings.get(i));
//		}
		for(int i = 0; i <= N-3; i++) {
			for(int j = i+1; j <= N-2; j++) {
				for(int s = 0; s <= i; s++) {
					String line = strings.get(s);
					for(int t = 0; t < M; t++) {
						if(line.charAt(t) != 'W') counter++;
					}
				}
//				System.out.println("counteri"+counter);

				for(int s = i+1; s <= j; s++) {
					for(int t = 0; t < M; t++) {
						String line = strings.get(s);
						if(line.charAt(t) != 'B') counter++;
					}
				}
//				System.out.println("counterj"+counter);
				
				for(int s = j+1; s <= N-1; s++) {
					String line = strings.get(s);
					for(int t = 0; t < M; t++) {
						if(line.charAt(t) != 'R') counter++;
					}
				}
//				System.out.println("counterk"+counter);
				
				if(counter < minCounter) minCounter = counter;
				counter = 0;
			}
		}
		System.out.println(minCounter);
	}

}
