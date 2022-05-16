package easy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DivideWater {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Float t = sc.nextFloat(); 
		Integer n = sc.nextInt();
		
		DecimalFormat df = new DecimalFormat("0.000");
		
		System.out.println(df.format(t/(float)n));
		System.out.println(2*n);
		sc.close();

	}

}
