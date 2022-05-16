package easy;

import java.util.Scanner;

public class Reverse {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Float num = sc.nextFloat();
		char[] chars = num.toString().toCharArray();
		
		for(int i = chars.length-1; i>=0; i-- ) {
			System.out.print(chars[i]);
		}
		sc.close();
	}

}
