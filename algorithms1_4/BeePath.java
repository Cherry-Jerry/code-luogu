package algorithms1_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BeePath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();
		ArrayList<BigInteger> array = new ArrayList<BigInteger>();
		array.add(0, BigInteger.ONE);
		array.add(1, BigInteger.ONE);
		for(int i =2 ;i <= n-m; i++) {
			array.add(i,array.get(i-1).add(array.get(i-2)));
		}
		System.out.println(array.get(n-m));
	}
}
