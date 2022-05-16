package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MingMingRandom {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(tokenizer.nextToken()) ;
		tokenizer = new StringTokenizer(reader.readLine());
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(tokenizer.nextToken()));
		}
		int length = set.size();
		out.println(length);
		out.flush();
		for(int i = 0; i < length; i++) {
			out.print(set.pollFirst()+" ");
			out.flush();
		}
	}
}
