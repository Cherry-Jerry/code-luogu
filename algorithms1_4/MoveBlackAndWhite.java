package algorithms1_4;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MoveBlackAndWhite {
	public static int n;
	public static StringBuilder originString = new StringBuilder();
	public static StringBuilder haveFinished = new StringBuilder();
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		for(int i = 0; i < n; ++i) {
			originString.append('o');
		}
		for(int i = 0; i < n; ++i) {
			originString.append('*');
		}
		originString.append("--");
		move();
	}
	private static void move() {
		if(n <= 4) {
			out.println("oooo****--"+ haveFinished.toString());
			out.println("ooo--***o*"+ haveFinished.toString());
			out.println("ooo*o**--*"+ haveFinished.toString());
			out.println("o--*o**oo*"+ haveFinished.toString());
			out.println("o*o*o*--o*"+ haveFinished.toString());
			out.println("--o*o*o*o*"+ haveFinished.toString());
			out.flush();
			return;
		}else {
			out.println(originString.toString()+haveFinished.toString());
			originString.replace(n-1, n+1, "--");
			originString.replace(originString.length()-2, originString.length(), "o*");
			out.println(originString.toString()+haveFinished.toString());
			out.flush();
			originString.replace(n-1, n+1, "**");
			originString.delete(originString.length()-4, originString.length());
			haveFinished.append("o*");
			n--;
			originString.append("--");
			move();
		}
	}
}
