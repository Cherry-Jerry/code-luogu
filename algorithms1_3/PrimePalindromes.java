package algorithms1_3;

import java.util.Scanner;

public class PrimePalindromes {
	public static int[] numbers;
	public static int step;//回文数的位数
	public static int palindroms = 0;
	public static int a;
	public static int b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		sc.close();
		for(step = (int)Math.log10(a)+1; step <= Math.log10(b)+1; step++) {
			numbers = new int[(step/2+1) +1];
			dfs(1);
		}
	}

	private static void dfs(int index) {
		if(index > step/2) {
			if(step % 2 == 0) {
				for(int i = 1; i <= step/2; i++) {
					palindroms += numbers[i]*myPow(10, step-i)+numbers[i]*myPow(10, i-1);
				}
				if((int)(Math.log10(palindroms)+1)==step && isPrime(palindroms) && a <= palindroms && palindroms <= b ) {
					System.out.println(palindroms);
				}
				palindroms = 0;
				return;
			}else if(step % 2 == 1) {

				for(int i = 1; i <= step/2; i++) {
					palindroms += numbers[i]*myPow(10, step-i)+numbers[i]*myPow(10, i-1);
				}
				for(int i = 0; i <10; i++) {
					palindroms += i*myPow(10, step -index);
					if((int)(Math.log10(palindroms)+1)==step && isPrime(palindroms) && a <= palindroms && palindroms <= b ) {
						System.out.println(palindroms);
					}
					palindroms -= i*myPow(10, step -index);
				}
				palindroms = 0;
				return;
				
			}else {
				System.out.println("unknown problem");
			}
		}
		
		for(int i = 0; i < 10; i++) {
			numbers[index] = i;
			dfs(index+1);
		}
	}

	private static int myPow(int a, int b) {
		return (int)Math.pow(a, b);
	}
	
	private static boolean isPrime(int number) {
		for(int i = 2; i < Math.sqrt(number)+1; i++) {
			if(number%i == 0){
				//System.out.println("number["+number+"]is not a prime.");
				return false;
			}
		}
		return true;
	}

}
