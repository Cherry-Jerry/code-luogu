package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KthMinByDivide {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt( tokenizer.nextToken());
		int k = Integer.parseInt( tokenizer.nextToken());
		tokenizer = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt( tokenizer.nextToken());
		}
		
		Qsort(a,0,n-1,k);
		for(int i = 0; i < n; i++) {
			out.print(a[i]+" ");
			out.flush();
		}
			out.print(a[k]);
			out.flush();
	}
	
	private static int Median3(int[] a,int Left,int Right){
		int Center = (Right+Left)/2;
		int tmp;
		
		if(a[Left] > a[Center]) {
			tmp = a[Left];
			a[Left] = a[Center];
			a[Center] = tmp;
		}
		if(a[Left] > a[Right]) {
			tmp = a[Left];
			a[Left] = a[Right];
			a[Right] = tmp;
		}
		if(a[Center] > a[Right]) {
			tmp = a[Center];
			a[Center] = a[Right];
			a[Right] = tmp;
		}
		tmp = a[Center];
		a[Center] = a[Right-1];
		a[Right-1] = tmp;
		return a[Right-1];
		
	}

	private static void Qsort(int[] a, int Left, int Right,int k) {
		int i,j;
		int p;
		int tmp;
		if(Left + 3 <= Right) {
			p = Median3(a,Left,Right);
			i = Left;
			j= Right -1;
			for(;;) {
				while(a[++i] < p) {};
				while(a[--j] > p) {};
				if(i < j) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}else {
					break;
				}
				tmp = a[i];
				a[i] = a[Right-1];
				a[Right-1] = tmp;
				
				for(int s = 0; s < 5; s++) {
					System.out.print(a[s]+" ");
				}
			
				if(k<=i) Qsort(a,Left,i-1,k);
				else if(k>i+1) Qsort(a,i+1,Right,k);
				}
		}else {
			Isort(a,Left,Right);
		}

	}
	private static void Isort(int[] a,int low,int high) {
		int min;
		int tmp;
		for(int i = low; i <high; i++) {
			min = i;
			for(int j = i; j < high; j++) {
				if(a[min] > a[j]) min = j;
			}
			tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}
	

}
