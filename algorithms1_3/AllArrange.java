package algorithms1_3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class AllArrange {
	public static boolean[] arrange;
	public static int[] result;
	public static int n;
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		n = System.in.read() - (int)'0';
		arrange = new boolean[n+1];
		result = new int[n+1];
		arrange(1);
		out.flush();
		long end = System.nanoTime();
		System.out.println("ºÄÊ±£º"+(end-start)/1000000+"ms");
	}
	private static void arrange(int index) {
		if(index > n) {
			for(int i = 1; i <= n; i++) {
				out.print("    "+result[i]);
			}
			out.println();
		}
		for(int i = 1; i<=n; i++ ) {
			if(!arrange[i]) {
				arrange[i] = true;
				result[index] = i;
				arrange(index+1);
				arrange[i] = false;
			}
		}
	}
	
}
