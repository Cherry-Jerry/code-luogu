package algorithms1_1;

import java.math.BigInteger;
import java.util.Scanner;

public class SumPow {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		BigInteger sumNum = new BigInteger("0");
		BigInteger powNum = new BigInteger("1");
		BigInteger count = new BigInteger("1");
		for(int i = 1; i <= n;i++) {
			powNum = powNum.multiply(count);
			sumNum = sumNum.add(powNum);
			count = count.add(BigInteger.ONE);
		}
		System.out.print(sumNum);
	}
	
}
