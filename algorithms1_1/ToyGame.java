package algorithms1_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Toy{
	int face;
	String name;
	public Toy(int face,String name) {
		this.face = face;
		this.name = name;
	}

}
class Saying{
	int towards;
	int steps;
	public Saying(int towards,int steps) {
		this.towards = towards;
		this.steps = steps;
	}
}



public class ToyGame {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer initTokenizer = new StringTokenizer(reader.readLine());
		int toyNum =  Integer.parseInt(initTokenizer.nextToken());
		int sayingsNum = Integer.parseInt(initTokenizer.nextToken());
		
//		System.out.println("toyNum="+toyNum);
//		System.out.println("sayingsNum="+sayingsNum);
		
		Toy[] toyArray = new Toy[toyNum];
		Saying[] sayingArray = new Saying[sayingsNum];
		StringTokenizer tokenizer;
		for(int i = 0; i < toyNum; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			toyArray[i] = new Toy(Integer.parseInt(tokenizer.nextToken()),tokenizer.nextToken());
		}
//		for(int i = 0; i < toyNum; i++) {
//			System.out.println("toyArray[i]:"+toyArray[i].face+toyArray[i].name);
//		}
		
		for(int i = 0; i < sayingsNum; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			sayingArray[i] = new Saying(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
		}
//		for(int i = 0; i < sayingsNum; i++) {
//		System.out.println("sayingArray[i]:"+sayingArray[i].towards+sayingArray[i].steps);
//	}
		int trueToy = 0;
		for(int i = 0; i < sayingsNum; i++) {
			if(Math.abs(toyArray[trueToy].face - sayingArray[i].towards) == 1) {
				trueToy += sayingArray[i].steps;
			} else {
				trueToy -= sayingArray[i].steps;
			}
			if(trueToy >= toyNum) {
				trueToy -= toyNum;
			}
			if(trueToy < 0) {
				trueToy += toyNum;
			}
		}
		System.out.println(toyArray[trueToy].name);
	}

}