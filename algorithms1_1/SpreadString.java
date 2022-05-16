package algorithms1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SpreadString {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int p1 = Integer.parseInt(tokenizer.nextToken());
		int p2 = Integer.parseInt(tokenizer.nextToken());
		int p3 = Integer.parseInt(tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		char[] array = tokenizer.nextToken().toCharArray();

		for(int i = 0; i <array.length; i++){
			if(array[i] != '-' || i == array.length -1 || i == 0 ) {
				System.out.print(array[i]);
			}else {
				if( array[i-1] != '-' && array[i+1] != '-'&& (array[i-1] - '0' <= 9 && array[i+1] - '0' <= 9 || array[i-1] - 'A' >= 0 && array[i+1] - 'A' >= 0) && array[i+1] - array[i-1] > 0) {
					if(array[i+1] - array[i-1] > 1) {
						StringBuilder sb = new StringBuilder();
						for(int j = 0; j < array[i+1] - array[i-1] -1; j++) {
							for(int k = 0; k < p2; k++) {
								sb.append((char)(array[i-1]+1+j));
							}
						}
						if(p3 == 2) {
							sb.reverse();
						}
						if(p1 == 2) {
							System.out.print(sb.toString().toUpperCase());
						}else if(p1 == 1) {
							System.out.print(sb.toString());
						}else {
							String str = sb.toString();
							for(int h = 0; h < str.length(); h++) {
									System.out.print("*");
									}
							}
						}
					}else {
						System.out.print("-");
					}
				}
			}
	}
}
