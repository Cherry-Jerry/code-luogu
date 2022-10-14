package RecoveryTraining;

import java.util.Scanner;

public class P5708 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		double p = (a+b+c)*0.5;
		double ans = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		System.out.printf("%2.1f", ans);
	}
}
