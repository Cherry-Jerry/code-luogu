package algorithms1_2;

import java.util.Scanner;

public class TurnTrain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		int tmp;
		int counter = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1-i; j++) {
				if(a[j] > a[j+1]) {
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					counter++;
				}
			}
		}
		System.out.println(counter);
	}

}
