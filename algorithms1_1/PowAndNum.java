package algorithms1_1;

import java.math.BigInteger;
import java.util.Scanner;

public class PowAndNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] n = new int[t];
		char[] a = new char[t];
		for(int i = 0; i < t; i++) {
			n[i] = sc.nextInt();
			a[i] =  String.valueOf(sc.nextInt()).charAt(0);
		}
		sc.close();
		String line;
		BigInteger bi;
		int counter;
		for(int i = 0; i < t; i++) {
			bi = new BigInteger("1");
			for(int j = 1; j <= n[i]; j++) {
				bi = bi.multiply(new BigInteger(String.valueOf(j)));
			}
			line = bi.toString();
			counter = 0;
			for(int k = 0; k < line.length(); k++) {
				if(line.charAt(k) == a[i]) counter++;
			}
			System.out.println(counter);
		}
		
	}

}
