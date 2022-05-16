package algorithms1_3;

import java.util.Scanner;

public class Match {
	public static void main(String[] args) {
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] mapper = {6,2,5,5,4,5,6,3,7,6};
		int[] match = new int[10000];
		for(int i = 0; i < 10; i++) {
			match[i] = mapper[i];
		}
		for(int i = 10; i < 100; i++) {
			match[i] = mapper[i%10]+mapper[i/10];
		}
		for(int i = 100; i < 1000; i++) {
			match[i] = mapper[i%10]+mapper[i/10%10]+mapper[i/100];
		}
		for(int i = 1000; i < 10000; i++) {
			match[i] = mapper[i%10]+mapper[i/10%10]+mapper[i/100%10]+mapper[i/1000];
		}
//		for(int i = 0; i < 10000; i++) {
//			System.out.print("match["+i+"]"+match[i]);
//			if(i%1000 ==0) {
//				System.out.println();
//			}
//		}
		for(int i = 0; i <10000; i++) {
			for(int j = i; j < 10000; j++) {
				if(i+j < 10000 && match[i] + match[j] + match[i+j] == n-4) {
					if(i == j) {
						counter++;
//						System.out.println(i+"/"+j+"/"+(i+j));
					}else {
						counter+=2;
//						System.out.println(i+"/"+j+"/"+(i+j));
					}
				}
			}
		}
		System.out.println(counter);
	}

}
