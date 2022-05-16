package algorithms1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MemoizingRecursion {
	public static HashMap<String,Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String abc; 
		while(true) {
			abc = br.readLine();
			if("-1 -1 -1".equals(abc)) {
				break;
			}else {
				StringTokenizer tokenizer = new StringTokenizer(abc);
				w(Long.parseLong(tokenizer.nextToken()),
						Long.parseLong(tokenizer.nextToken()),
						Long.parseLong(tokenizer.nextToken()));
				outPut(abc);
			}
		}
	}
	private static void outPut(String abc) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(abc);
		sb.append("w(")
		.append(tokenizer.nextToken())
		.append(", ")
		.append(tokenizer.nextToken())
		.append(", ")
		.append(tokenizer.nextToken())
		.append(") = ")
		.append(map.get(abc));
		System.out.println(sb.toString());
		
	}
	private static long w(long a, long b, long c) {
		StringBuilder sb = new StringBuilder();
		String abc = sb.append(a).append(" ").append(b).append(" ").append(c).toString();
		Long result = map.get(abc);
		if(result != null) {
			return result;
		}
		if(a <= 0 || b <= 0 || c <= 0) {
			result =  1L;
		}else if(a > 20 || b > 20 || c > 20) {
			result =  w(20,20,20);
		}else if(a < b && b < c) {
			result = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}else {
			result = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
		}
		map.put(abc, result);
		return result;
	}
}
