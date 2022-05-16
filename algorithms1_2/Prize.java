package algorithms1_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	int sumScore;
	int Chinese;
	int id;

	@Override
	public int compareTo(Student o) {
		if(this.sumScore > o.sumScore) return 1;
		else if (this.sumScore < o.sumScore)return-1;
		else {
			if(this.Chinese > o.Chinese)return 1;
			else if(this.Chinese < o.Chinese)return -1;
			else {
				if(this.id < o.id)return 1;
				else if(this.id > o.id)return -1;
				else {
					return 0;
				}
			}
		}
	}
	
}

public class Prize {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		TreeSet<Student> set = new TreeSet<Student>();
		
		Student student;
		for(int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			student = new Student();
			student.Chinese = Integer.parseInt(tokenizer.nextToken());
			student.sumScore = student.Chinese + Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken());
			student.id = i+1;
			set.add(student);
		}
		int length = set.size();
		if(length < 5) {
			for(int i = 0; i < length; i++) {
				student = set.pollLast();
				System.out.println(student.id+" "+student.sumScore);
			}
		}else {
			for(int i = 0; i < 5; i++) {
				student = set.pollLast();
				System.out.println(student.id+" "+student.sumScore);
			}
		}
	}

}
