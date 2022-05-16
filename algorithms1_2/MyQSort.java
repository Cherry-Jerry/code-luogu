package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// 自己写一次快排， 增加优化 a.选择基准 b.尾递归 c.聚集元素
public class MyQSort {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
		int N = Integer.parseInt( tokenizer.nextToken());
		tokenizer = new StringTokenizer(reader.readLine());
		
		int[] a = new int[N];
		for(int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Qsort(a,0,N);
		for(int i = 0; i < N; i++) {
			out.print(a[i]+" "); 
			out.flush();
		}
	}

	private static void Qsort(int[] a, int low, int high) {
		if(high - low < 20) {	//优化一
			Isort(a,low,high);
			return;
		}
		int Left = low;
		int Right = high;
		int Center = (low + high)/2;
		int tmp;
		
		int base = a[Center];
		a[Center] =a[Left];
		while(Left != Right){
			while(Left != Right && a[--Right] > base);
			if(Left != Right) {
				tmp = a[Left];
				a[Left] = a[Right];
				a[Right] = tmp;
			}
			while(Left != Right && a[++Left] < base);
			if(Left != Right) {
				tmp = a[Left];
				a[Left] = a[Right];
				a[Right] = tmp;
			}
		}
		Center = Right;
		a[Center] = base;
		Qsort(a,low,Center);
		Qsort(a,Center+1,high);
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
