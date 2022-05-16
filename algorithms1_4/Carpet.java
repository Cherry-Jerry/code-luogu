package algorithms1_4;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carpet {
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		int length = (int)Math.pow(2, k);
		divide(length, x, y,0,0);
		out.flush();
	}

	private static void divide(int length, int x, int y, int u, int v) {
		int div = length/2;
		if(length == 1) {
			return;
		}
		if(x <= div && y <= div) {
			out.println((div+1+u)+" "+(div+1+v)+" 1");
			out.flush();
			divide(div,x,y,u+0,v+0);
			divide(div,div,1,u+0,v+div);
			divide(div,1,div,u+div,v+0);
			divide(div,1,1,u+div,v+div);
		}else if(x <= div && y > div) {
			out.println((div+1+u)+" "+(div+v)+" 2");
			out.flush();
			divide(div,div,div,u+0,v+0);
			divide(div,x,y-div,u+0,v+div);
			divide(div,1,div,u+div,v+0);
			divide(div,1,1,u+div,v+div);
		}else if(x > div && y <= div) {
			out.println((div+u)+" "+(div+1+v)+" 3");
			out.flush();
			divide(div,div,div,u+0,v+0);
			divide(div,div,1,u+0,v+div);
			divide(div,x-div,y,u+div,v+0);
			divide(div,1,1,u+div,v+div);
			
		}else {
			out.println((div+u)+" "+(div+v)+" 4");
			out.flush();
			divide(div,div,div,u+0,v+0);
			divide(div,div,1,u+0,v+div);
			divide(div,1,div,u+div,v+0);
			divide(div,x-div,y-div,u+div,v+div);
		}
	}
}
