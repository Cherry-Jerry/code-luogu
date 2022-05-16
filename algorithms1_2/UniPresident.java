package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
public class UniPresident {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		String line;
		for(int i = 0; i < n; i++) {
			line = br.readLine();
				list.add(new BigInteger(line));
		}
		int max = 0;
		for(int i = 1; i < list.size(); i++) {
			if (list.get(max).compareTo(list.get(i)) < 0) {
				max = i;
			}
		}
		System.out.println(max+1);
		System.out.println(list.get(max));
	}

}
