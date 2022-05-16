package algorithms1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Interviewee  implements Comparable<Interviewee>  {
	int id;
	int score;
	@Override
	public int compareTo(Interviewee o) {
		if(this.score > o.score) return 1;
		else if(this.score < o.score) return -1;
		else {//同分数，id小的排前面
			if(this.id < o.id) return 1;
			else if(this.id > o.id) return -1;
			else return 0;
		}
	}
	
	
}
public class ScoreLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(tokenizer.nextToken());
		int M = (int)(1.5*Integer.parseInt(tokenizer.nextToken()));
		
		TreeSet<Interviewee> set = new TreeSet<Interviewee>();
		Interviewee interviewee = null;
		for(int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			interviewee = new Interviewee();
			interviewee.id = Integer.parseInt(tokenizer.nextToken());
			interviewee.score = Integer.parseInt(tokenizer.nextToken());
			set.add(interviewee);
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(i = 0; i < M; i++) {
			interviewee = set.pollLast();
			sb.append(interviewee.id).append(" ").append(interviewee.score).append("\n");
		}
		Interviewee nextInterviewee = null;
		while((nextInterviewee = set.pollLast()).score == interviewee.score) {
			i++;
			sb.append(nextInterviewee.id).append(" ").append(nextInterviewee.score).append("\n");
		}
		out.println(interviewee.score+" "+i);
		out.print(sb.toString());
		out.flush();
	}
}
