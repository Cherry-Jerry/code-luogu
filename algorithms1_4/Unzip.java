package algorithms1_4;

import java.util.Scanner;

public class Unzip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		sc.close();
		System.out.println(unzip(code));
	}
	//构成A[MB]C  A:前缀，[MB]:中值，C后缀
	//输出前缀A
	//解压中值和后缀[MB]C：分割M、B，解压B得到b，再返回M*b，最后输出后缀
	private static String unzip(String code) {
		//前缀
		int index1 = 0;
		while(code.charAt(index1) != '[') {
			index1++;
			if(index1 == code.length()) {
				return code;
			}
		}
		String prefix = "";
		if(index1 != 0) {
			prefix = code.substring(0,index1);
		}
		//后缀
		int index2 = code.length()-1;
		while(code.charAt(index2) != ']') {index2--;}
		String suffix = "";
		if(index2 != code.length()-1) {
			suffix = code.substring(index2+1);
		}
		//中值
		String middle ="";
		int D;
		String X;
		if('1'<= code.charAt(index1+1) && code.charAt(index1+1) <= '9' &&
				'0'<= code.charAt(index1+2) && code.charAt(index1+2) <= '9') {
			D = (code.charAt(index1+1) - '0')*10 + (code.charAt(index1+2) - '0');
			X = code.substring(index1+3,index2); 
		}else {
			D = code.charAt(index1+1) - '0';
			X = code.substring(index1+2,index2); 
		}
		X = unzip(X);
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0; i < D; i++) {
			sb.append(X);
		}
		middle = sb.toString();
		return prefix + middle + suffix;
		
	}
}
      