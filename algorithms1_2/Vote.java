package algorithms1_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Vote {
	public static void main(String[] args) throws IOException {
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		int n =(int) in.nval;
		in.nextToken();
		int m = (int) in.nval;
		int[] candidate = new int[n+1];
		for(int i = 0; i < m; i++) {
			in.nextToken();
			candidate[(int)in.nval]++;
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 0; j < candidate[i]; j++) {
				out.print(i+" ");
				out.flush();
			}
		}
	}
}