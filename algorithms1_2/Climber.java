package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Point implements Comparable<Point>{
	int x;
	int y;
	int z;
	@Override
	public int compareTo(Point o) {
		if(this.z > o.z) return 1;
		else if(this.z < o.z) return -1;
		else return 0;
	}
	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Climber {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		TreeSet<Point> set =   new TreeSet<Point>();
		for(int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			set.add(new Point(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
		}
		double s = 0.0;
		Point p1 = set.pollFirst(),p2 = set.pollFirst();
		for(int i = 0; i < N-1; i++) {
			s += Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)+(p1.z-p2.z)*(p1.z-p2.z));
			p1 = p2;
			p2 = set.pollFirst();
		}
		System.out.println(String.format("%.3f", s));
		
	}

}
