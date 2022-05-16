package easy;

import java.util.Scanner;

public class HourAndMinue {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Integer a = sc.nextInt();
		Integer b = sc.nextInt();
		
		Integer c = sc.nextInt();
		Integer d = sc.nextInt();
		
		Integer e=0,f=0;
		
		f=d-b;
		if(f<0) {
			e--;
			f+=60;
		}
		e+=c-a;
		System.out.println(e+" "+f);
		sc.close();
	}


}
