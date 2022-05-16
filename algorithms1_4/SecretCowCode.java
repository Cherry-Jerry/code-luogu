package algorithms1_4;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SecretCowCode {
	public static String code;
	public static long answerIndex;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer tokenizer = new StringTokenizer(sc.nextLine());
		sc.close();
		code = tokenizer.nextToken();
		long N = Long.parseLong(tokenizer.nextToken());
		long length = code.length();
		while(length < N) {
			length *= 2;
		}
		find(N, length);
		System.out.println(code.charAt((int)answerIndex-1));
	}

	private static void find(long index, long length) {
		if(index <= code.length()) {
			answerIndex = index;
			return;
		}
		
		if (index == length/2+1) {
			find(index-1,length/2);
		}else if (index > length/2+1) {
			find(index-length/2-1,length/2);
		}else if (index < length/2+1) {
			find(index,length/2);
		}
	}
}
