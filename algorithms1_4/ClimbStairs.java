package algorithms1_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class ClimbStairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		ArrayList<BigInteger> a = new ArrayList<BigInteger>(5001);
		a.add(0, BigInteger.ONE);
		a.add(1, BigInteger.ONE);
		for(int i = 2; i <=N; i++) {
			a.add(i, a.get(i-1).add(a.get(i-2)));
		}
		System.out.println(a.get(N));
	}

}

