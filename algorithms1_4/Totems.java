package algorithms1_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Totems {
	public static ArrayList<StringBuilder> lines = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for(int i = 0; i < Math.pow(2, n);++i){
			lines.add(new StringBuilder());
		}
		draw(n,0);
		for(int i = 0; i < Math.pow(2, n);++i){
			System.out.println(lines.get(i));
		}
	}

	private static void draw(int n, int line) {
		if(n == 1) {
			lines.get(line).append(" /\\ ");
			lines.get(line+1).append("/__\\");
			return;
		}
		StringBuilder blank = new StringBuilder();
		int length = (int) Math.pow(2,n-1);
		for(int i = 0; i < length;++i) {
			blank.append(" ");
		}
		String blankspace = blank.toString();
		// 加空格
		for(int i = line; i < line+length; ++i) {
			lines.get(i).append(blankspace);
		}
		// 添加第一部分
		draw(n-1,line);
		// 加空格
		for(int i = line; i < line+length; ++i) {
			lines.get(i).append(blankspace);
		}
		// 加第二部分
		draw(n-1,line+length);
		//加第三部分
		draw(n-1,line+length);
	}

}
