package algorithms1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class ExtendedStringTokenizer extends StringTokenizer{
	public ExtendedStringTokenizer(String str){
		super(str);
	}
	public Integer nextInt() {
		return Integer.parseInt(this.nextToken());
	}
}

public class Scarlet {
	public static void main(String[] args) throws IOException {
		int m,n;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ExtendedStringTokenizer tokenizer = new ExtendedStringTokenizer(reader.readLine());
		n = tokenizer.nextInt();
		m = tokenizer.nextInt();
		int[][] resultArray = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				resultArray[i][j] = i*n + j + 1;
			}
		}

		for(int i = 0; i < m;i++) {
			tokenizer = new ExtendedStringTokenizer(reader.readLine());
			magic(resultArray,tokenizer.nextInt(),tokenizer.nextInt(),tokenizer.nextInt(),tokenizer.nextInt());
		}
		
		printResult(resultArray ,n);
		

	}
	public static void magic(int[][] resultArray, int x,int y,int r,int z){
		int firstX = x - 1 - r;
		int firstY = y - 1 - r;
		int length = 2*r+1;
		int[][] tmpArray = new int[length][length];
		if(z == 0) {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					tmpArray[j][length-1-i] =  resultArray[firstX+i][firstY+j];
					}
				}
			}else {
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < length; j++) {
					tmpArray[length-1-j][i] =  resultArray[firstX+i][firstY+j];
					}
				}
			}
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				resultArray[firstX+i][firstY+j] =  tmpArray[i][j];
				}
			}
	
	
	}

	public static void printResult(int[][] array ,int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(array[i][j] +" ");
			}
			System.out.println();
		}
	}
}
