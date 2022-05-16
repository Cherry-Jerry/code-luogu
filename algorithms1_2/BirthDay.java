package algorithms1_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Classmate implements Comparable<Classmate>{
	String name;
	int year;
	int month;
	public Classmate(String name, int year, int month, int day) {
		super();
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	int day;
	@Override
	public int compareTo(Classmate o) {
		if(this.year > o.year) return 1;
		else if(this.year < o.year) return -1;
		else {
			if(this.month > o.month) return 1;
			else if(this.month < o.month) return -1;
			else {
				if(this.day > o.day) return 1;
				else if(this.day < o.day) return -1;
				else return -1;
			}
		}
	}
}

public class BirthDay {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		TreeSet<Classmate> set =   new TreeSet<Classmate>();
		for(int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			set.add(new Classmate(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken())));
		}
		for(int i = 0; i < N; i++) {
			System.out.println(set.pollFirst().name);
		}
	}

}
