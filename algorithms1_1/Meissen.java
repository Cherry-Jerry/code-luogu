package algorithms1_1;

import java.math.BigInteger;
import java.util.Scanner;

public class Meissen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		BigInteger bi =new BigInteger("2");
		bi = bi.pow(p).subtract(BigInteger.ONE);
		//String line = bi.toString();
		System.out.println(bi);
//		if(line.length() > 500) {
//			System.out.println(line.substring(line.length()-1-500, line.length()-1));
//		}else {
//			System.out.println();
//			for(int i = 0; i < 500 - line.length(); i++) {
//				System.out.print(0);
//			}
//			System.out.print(line);
//			
//		}
		sc.close();
	}
}
