package DP_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
class Cave{
	int value;
	int maxOrigin;
	int sum;
	public Cave(int value, int maxOrigin, int sum) {
		super();
		this.value = value;
		this.maxOrigin = maxOrigin;
		this.sum = sum;
	}
}
public class CaveAndMines {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Cave> caves = new ArrayList<>();
		caves.add(0, new Cave(0,0,0));
		int mines = 0;
		for(int i = 1; i <= N; i++) {
			mines = sc.nextInt();
			caves.add(i,new Cave(mines,0,mines));
		}
		int[][] connect = new int[N+1][N+1];
		int[] in = new int[N+1];
		int[] out = new int[N+1];
		for(int i = 1; i <= N-1; i++) {
			for(int j = i+1; j <= N; j++) {
				if(sc.nextInt() == 1) {
					out[i]++;
					in[j]++;
					connect[i][j] = 1;
				}
			}
		}
		sc.close();
		// ÕÒÆðµã
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i= 1; i <= N; i++) {
			if(in[i] == 0) {
				queue.add(i);
			}
		}
		int i,lastSum,thisSum,thisValue;
		while(!queue.isEmpty()) {
			i = queue.removeFirst();
			in[i]--; //in[i] = -1
			for(int j = 1; j <= N; j++) {
				if(connect[i][j] == 1) {
					out[i]--;
					in[j]--;
					lastSum = caves.get(i).sum;
					thisSum = caves.get(j).sum;
					thisValue = caves.get(j).value;
					if(lastSum + thisValue > thisSum) {
						caves.get(j).maxOrigin = i;
						caves.get(j).sum = lastSum +thisValue;
					}
					if(in[j] == 0) {
						queue.add(j);
					}
				}
			}
		}
		int maxMineIndex = 0;
		for(int m = 1 ; m <= N; m++) {
			if(caves.get(maxMineIndex).sum < caves.get(m).sum) {
				maxMineIndex = m;
			}
		}
		LinkedList<Integer> stack = new LinkedList<>();
		stack.add(maxMineIndex);
		int father = caves.get(maxMineIndex).maxOrigin;
		while(father != 0) {
			stack.add(father);
			father = caves.get(father).maxOrigin;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.removeLast());
			if(stack.size() == 0) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
		}
		System.out.println(caves.get(maxMineIndex).sum);
	}
}
