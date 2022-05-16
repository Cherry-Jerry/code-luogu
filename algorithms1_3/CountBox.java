package algorithms1_3;

import java.util.Scanner;
public class CountBox {
	//���������ù�ʽ���������������
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		sc.close();
		long rectangleCounter = 0;
		long squareCounter = 0;
		//�����������
		rectangleCounter = (1+n)*n/2 * (1+m)*m/2;
		//��������������
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
