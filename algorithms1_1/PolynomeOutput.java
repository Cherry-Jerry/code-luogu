package algorithms1_1;

import java.util.Scanner;

public class PolynomeOutput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ratio = new int [n+1];
		for(int i = 0;i < n+1; i++) {
			ratio[i] = sc.nextInt();
		}
		sc.close();
		for(int i = 0;i < n+1; i++) {
			// 输出第一项
			if(i == 0) {
				if(ratio[i] == -1) {
					System.out.print("-"+"x^"+n);
				}else if(ratio[i] == 1){
					System.out.print("x^"+n);
				}else{
					System.out.print(ratio[i]+"x^"+n);
				}

				
			} else if(i == n) {

				if(ratio[i] > 0) {
					System.out.print("+"+ratio[i]);
				} 
				if(ratio[i] < 0) {
					System.out.print(ratio[i]);
				} 
			} else if(i == n-1){
				if(ratio[i] == 1) {
					System.out.print("+"+"x");
				} 
				if(ratio[i] == -1) {
					System.out.print("-"+"x");
				} 
				if(ratio[i] > 1) {
					System.out.print("+"+ratio[i]+"x");
				} 
				if(ratio[i] < -1) {
					System.out.print(ratio[i]+"x");
				} 
			}else {
				if(ratio[i] == 1) {
					System.out.print("+"+"x^"+(n-i));
				} 
				if(ratio[i] == -1) {
					System.out.print("-"+"x^"+(n-i));
				} 
				if(ratio[i] > 1) {
					System.out.print("+"+ratio[i]+"x^"+(n-i));
				} 
				if(ratio[i] < -1) {
					System.out.print(ratio[i]+"x^"+(n-i));
				} 
			}

		}
		
		
	}

}
