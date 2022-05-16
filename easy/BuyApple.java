package easy;

import java.util.Scanner;
import java.math.*;

public class BuyApple {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger c = a.multiply(b);
		System.out.println(c);
		sc.close();
	}


}
