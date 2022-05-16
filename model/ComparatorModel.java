package model;

import java.util.ArrayList;
import java.util.Comparator;

class MyObject{
	int a;
	int b;
	int c;
	public MyObject(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public String toString() {
		return "MyObject [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	
}
class MyComparator implements Comparator<MyObject>{

	@Override
	public int compare(MyObject o1, MyObject o2) {
		if(o1.a != o2.a) {
			return o1.a - o2.a;
		}else if(o1.b != o2.b){
			return o1.b - o2.b;
		}else {
			return o1.c - o2.c;
		}
	}
	
}

public class ComparatorModel {
	public static void main(String[] args) {
		ArrayList<MyObject> alist = new ArrayList<>();
		alist.add(new MyObject(13,1,3));
		alist.add(new MyObject(13,22,3));
		alist.add(new MyObject(4,43,3));
		alist.add(new MyObject(13,43,3));
		alist.add(new MyObject(13,43,5));
		alist.add(new MyObject(9,22,3));
		alist.add(new MyObject(6,43,3));
		alist.sort(new MyComparator());
		System.out.println(alist.toString());
	}

}
