package algorithms1_4;

import java.util.Scanner;

public class PowerOfTwo {
	public static boolean[] known;
	public static String[] answer;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		known = new boolean[n+1];
		answer = new String[n+1];
		

		answer[0] = "0";
		known[0] = true;
		
		answer[1] = "2(0)";
		known[1] = true;
		
		answer[2] = "2";
		known[2] = true;
		System.out.println(format(n));
	}

	private static String format(Integer n) {
		if(known[n]) {
			return answer[n];
		}else {
			StringBuilder sb = new StringBuilder();
			String line;
			String binary = Integer.toBinaryString(n);
			for(int i = 0; i < binary.length(); ++i) {
				if(binary.charAt(i) == '1') {
					line = "2("+format(binary.length()-1-i)+")+";
					if("2(2(0))+".equals(line)) {//»¯¼ò
						line = answer[2]+"+";
					}
					sb.append(line);
				}
			}
			sb.deleteCharAt(sb.length()-1);//É¾µô×îºó¡®+¡¯
			known[n] = true;
			answer[n] = sb.toString();
			return answer[n];
		}
	}
}
