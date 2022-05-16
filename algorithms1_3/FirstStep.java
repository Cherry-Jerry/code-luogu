package algorithms1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FirstStep {
	public static int counter = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		错因：RCK.charAt(0)只能读入一个数字，然而R、C、K可能是两位数
//		String RCK = br.readLine();
//		int R = RCK.charAt(0) - '0';
//		int C = RCK.charAt(2) - '0';
//		int K = RCK.charAt(4) - '0';
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		char[][] a = new char[R][C];
		String line;
		for(int i = 0; i < R; i++) {
			line = br.readLine();
			for(int j = 0; j < C; j++) {
				a[i][j] = line.charAt(j);
			}
		}
		// 按列排
		int startIndex = 0;
		int endIndex = 0;
		int c = 0;
		while(c < C) {
			while(endIndex < R && a[endIndex][c] == '.' && endIndex-startIndex < K) {
				endIndex++;
			}
			if(endIndex-startIndex == K){
				counter++;
				startIndex++;
				endIndex = startIndex;
			}else if(endIndex >= R) {
				c++;
				endIndex = 0; 
				startIndex = endIndex;
			}else if(a[endIndex][c] == '#'){
				while(endIndex < R && a[endIndex][c] == '#') {endIndex++;}
				startIndex = endIndex;
			}else {
				System.out.println("counter:"+counter);
			}
		}
		if(K!=1) {
			// 按行排
			startIndex = 0;
			endIndex = 0;
			int r = 0;
			while(r < R) {
				while(endIndex < C && a[r][endIndex] == '.' && endIndex-startIndex < K) {
					endIndex++;
				}
				if(endIndex-startIndex == K){
					counter++;
					startIndex++;
					endIndex = startIndex;
				} else if(endIndex >= C) {
					r++;
					endIndex = 0; 
					startIndex = endIndex;
				}else if(a[r][endIndex] == '#'){
					while(endIndex < C && a[r][endIndex] == '#') {endIndex++;}
					startIndex = endIndex;
				}else {
					System.out.println("counter:"+counter);
				}
			}	
		}
		System.out.println(counter);
	}
}
