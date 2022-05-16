package algorithms1_3;

import java.util.Scanner;

public class Sauce {
	public static StringBuilder sb = new StringBuilder();
	public static int counter = 0;
	public static int[] a = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rest = sc.nextInt();
		sc.close();
		for(int i = 1; i <= 3; i++) {
			addSauce(rest, 0, i);
		}
		System.out.println(counter);
		System.out.println(sb.toString());
	}
	static void addSauce(int rest, int index, int gram) {
		rest -= gram;
		a[index] = gram;
		if(rest > 0 && index < 9) {
			for(int i = 1; i <= 3; i++) {
				addSauce(rest, index+1, i);
			}
		}else if(rest == 0 && index == 9){
			for(int j = 0; j < 10; j++) {
				sb.append(a[j]).append(" ");
			}
			sb.append("\n");
			counter++;
		}
	}
}
