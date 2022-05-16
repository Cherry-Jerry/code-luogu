package algorithms1_3;

import java.util.Scanner;

public class TripleAttack {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		int tmpA=0;
		int tmpB=0;
		int tmpC=0;
		for(int i = 1;true; i++) {
			tmpA = A*i;
			if(tmpA < 100) {
				continue;
			}
			tmpC = C*i;
			if(tmpC >= 1000) {
				break;
			}
			tmpB = B*i;
			
			int[] a = {1,0,0,0,0,0,0,0,0,0}; 
			a[tmpA%10] = 1;
			if(a[tmpA/10%10] != 1) a[tmpA/10%10] = 1;
			else continue;
			if(a[tmpA/100] != 1) a[tmpA/100] = 1;
			else continue;
			if(a[tmpB%10] != 1) a[tmpB%10] = 1;
			else continue;
			if(a[tmpB/10%10] != 1) a[tmpB/10%10] = 1;
			else continue;
			if(a[tmpB/100] != 1) a[tmpB/100] = 1;
			else continue;
			if(a[tmpC%10] != 1) a[tmpC%10] = 1;
			else continue;
			if(a[tmpC/10%10] != 1) a[tmpC/10%10] = 1;
			else continue;
			if(a[tmpC/100] != 1) a[tmpC/100] = 1;
			else continue;
			if(tmpA != tmpB && tmpB != tmpC && tmpC != tmpA) {
				sb.append(tmpA).append(" ").append(tmpB).append(" ").append(tmpC).append("\n");
			}
		}
		if(sb.toString().isEmpty()) {
			System.out.println("No!!!");
		}else {
			System.out.println(sb.toString());
		}
	}

}
