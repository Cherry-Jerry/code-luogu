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
		// 读入一个字符，如果是E，结束读取
		while((c = System.in.read()) != 'E') {
			// 如果该字符是W 华华得一分
			if(c == 'W') {
				W_11++;
				W_21++;
			}
			// 如果是L 对手得一分
			if(c == 'L') {
				L_11++;
				L_21++;
			}
			// 判断是否完成一局比赛 是：存入结果集并把得分置零，不是：继续读入下一个字符
			//对于11分制完成一局的条件：其中一方得分大于等于11，且分数差大于等于2
			if((W_11 >=11 || L_11 >= 11) && Math.abs(W_11-L_11) >=2) {
				result_11 = new Result();
				result_11.W = W_11;
				result_11.L = L_11;
				results_11.add(result_11);
				W_11 =0;
				L_11 =0;
			}
			//对于21分制完成一局的条件：其中一方得分大于等于21，且分数差大于等于2
			if((W_21 >=21 || L_21 >= 21) && Math.abs(W_21-L_21) >=2) {
				result_21 = new Result();
				result_21.W = W_21;
				result_21.L = L_21;
				results_21.add(result_21);
				W_21 =0;
				L_21 =0;
			}
		}
		// 把进行中的比赛也写入结果集
		result_11 = new Result();
		result_11.W = W_11;
		result_11.L = L_11;
		results_11.add(result_11);
		
		result_21 = new Result();
		result_21.W = W_21;
		result_21.L = L_21;
		results_21.add(result_21);
		
		// 输出结果集
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
