package algorithms1_4;

import java.util.Scanner;

public class UnzipSuccess {
	public static String line;
	public static int index;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		line = sc.nextLine();
		sc.close();
		System.out.print(unzip());
	}
	private static String unzip() {
		int D = 0;
		String X= "";
		StringBuilder sb = new StringBuilder();
		while(index < line.length()) {
			char c = line.charAt(index++);
			if(c == '[') {
				if('1'<= line.charAt(index) && line.charAt(index) <= '9' &&
						'0'<= line.charAt(index+1) && line.charAt(index+1) <= '9') {
					D = (line.charAt(index) - '0')*10 + (line.charAt(index+1) - '0');
					//System.out.println("D:"+D);
					index += 2;
				}else {
					D = line.charAt(index) - '0';
					//System.out.println("D:"+D);
					index++;
				}
				X = unzip();
				for(int i = 0; i < D; i++) {
					sb.append(X);
				}

			} else if(c == ']'){
				return sb.toString();
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
