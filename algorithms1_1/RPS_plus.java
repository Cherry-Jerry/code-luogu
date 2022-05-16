package algorithms1_1;

import java.util.Scanner;

public class RPS_plus {
	static int[][] relation = new int[][] {{0,-1,1,1,-1},{1,0,-1,1,-1},{-1,1,0,-1,1},{-1,-1,1,0,1},{1,1,-1,-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int NA = sc.nextInt();
		int NB = sc.nextInt();
		int[] gestrueA =  new int[NA];
		int[] gestrueB =  new int[NB];
		for(int i = 0; i < NA; i++) {
			gestrueA[i] = sc.nextInt();
		}
		for(int i = 0; i < NB; i++) {
			gestrueB[i] = sc.nextInt();
		}
		sc.close();
		int Anext = 0;
		int Bnext = 0;
		int Awin = 0;
		int Bwin = 0;
		int result =0;
		for(int i = 0; i < N; i++) {
			result = getResult(gestrueA[Anext++],gestrueB[Bnext++]);
			if(result == 1) Awin++;
			if(result == -1) Bwin++;

			if(Anext >= NA) Anext -= NA;
			if(Bnext >= NB) Bnext -= NB;
		}
		
		System.out.println(Awin + " "+Bwin);
		
	}
	public static int getResult(int A, int B) {
		return relation[A][B];
	}
	
}
