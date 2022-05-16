package algorithms1_1;


import java.io.IOException;
import java.util.*;

class Result {
	int W;
	int L;
}
public class PingPangCounter {
	
	public static void main(String[] args) throws IOException  {
		int W_11=0,W_21=0;
		int L_11=0,L_21=0;
		Result result_11=null;
		Result result_21=null;
		LinkedList<Result> results_11 = new LinkedList<Result>();
		LinkedList<Result> results_21 = new LinkedList<Result>();
		int c;
		// ����һ���ַ��������E��������ȡ
		while((c = System.in.read()) != 'E') {
			// ������ַ���W ������һ��
			if(c == 'W') {
				W_11++;
				W_21++;
			}
			// �����L ���ֵ�һ��
			if(c == 'L') {
				L_11++;
				L_21++;
			}
			// �ж��Ƿ����һ�ֱ��� �ǣ������������ѵ÷����㣬���ǣ�����������һ���ַ�
			//����11�������һ�ֵ�����������һ���÷ִ��ڵ���11���ҷ�������ڵ���2
			if((W_11 >=11 || L_11 >= 11) && Math.abs(W_11-L_11) >=2) {
				result_11 = new Result();
				result_11.W = W_11;
				result_11.L = L_11;
				results_11.add(result_11);
				W_11 =0;
				L_11 =0;
			}
			//����21�������һ�ֵ�����������һ���÷ִ��ڵ���21���ҷ�������ڵ���2
			if((W_21 >=21 || L_21 >= 21) && Math.abs(W_21-L_21) >=2) {
				result_21 = new Result();
				result_21.W = W_21;
				result_21.L = L_21;
				results_21.add(result_21);
				W_21 =0;
				L_21 =0;
			}
		}
		// �ѽ����еı���Ҳд������
		result_11 = new Result();
		result_11.W = W_11;
		result_11.L = L_11;
		results_11.add(result_11);
		
		result_21 = new Result();
		result_21.W = W_21;
		result_21.L = L_21;
		results_21.add(result_21);
		
		// ��������
		while(!results_11.isEmpty()) {
			result_11 = results_11.removeFirst();
			System.out.println(result_11.W+":"+result_11.L);
		}
		System.out.println();
		while(!results_21.isEmpty()) {
			result_21 = results_21.removeFirst();
			System.out.println(result_21.W+":"+result_21.L);
		}
	}
}
