package algorithms1_3;

import java.util.Scanner;
public class CountBox {
	//矩形数量用公式，正方形数量穷举
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		sc.close();
		long rectangleCounter = 0;
		long squareCounter = 0;
		//计算矩形总数
		rectangleCounter = (1+n)*n/2 * (1+m)*m/2;
		//计算正方形总数
		long tmp;
		if(n > m) {
			tmp = n;
			n = m;
			m = tmp;
		}
		for(long i = 0; i < n; i++) {
			squareCounter += (n-i)*(m-i);
		}
		System.out.println(squareCounter+" "+(rectangleCounter-squareCounter));
	}
}
