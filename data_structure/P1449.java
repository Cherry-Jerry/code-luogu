package data_structure;

import java.util.LinkedList;
import java.util.Scanner;

public class P1449 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.next();
		sc.close();
		char c;
		int l = line.length();
		int num = 0;
		int num1, num2;

		LinkedList<Integer> stack = new LinkedList<>();
		for(int i = 0;i < l; i++) {
			c =line.charAt(i);
			switch(c) {
			case '.':stack.add(num);num=0;break;
			case '+':num1=stack.removeLast();num2=stack.removeLast();stack.add(num2+num1);break;
			case '-':num1=stack.removeLast();num2=stack.removeLast();stack.add(num2-num1);break;
			case '*':num1=stack.removeLast();num2=stack.removeLast();stack.add(num2*num1);break;
			case '/':num1=stack.removeLast();num2=stack.removeLast();stack.add(num2/num1);break;
			case '@':System.out.println(stack.removeLast());break;
			default:num = num*10+(int)(c-'0');break;
			}
		}
		
	}

}
