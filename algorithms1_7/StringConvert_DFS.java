package algorithms1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *  DFS方法在测试数据
 *a aaaaa
 *a a112233445566778899
 *778899 a
 *112233 a
 *445 a
 *566 a
 *55 a
 *下超时
 *超时原因：在错误方向无效搜索  a --> a112233445566778899 --> a112233445566778899112233445566778899
 */
// 数组保存映射方式
// 遍历映射数组，扫描当前字符串，如果匹配深搜
// 全局StringBuilder 保存结果当前字符串
// DFS 超过 10 层跳出，如果遍历完还没任何可达方法，输出 NO ANSWER! ，每次找到一条路径，取答案最小（index，steps）
// 复杂度分析：每层DFS的遍历方向最大为20，通过扫描方法，字符不在该方向就不DFS，递归调用最深为10，不会栈溢出
// 为了可回溯，应该要保存每一阶的String结果
// 字符串处理：1、把某个字符段替换为另外一个字符串，2、判断某个字符段是否在字符串内
public class StringConvert_DFS {
	public static int steps = Integer.MAX_VALUE;
	public static String B = null;
	public static String[] keys = new String[7];
	public static String[] values = new String[7];
	public static String[] keysRegax = new String[7];
	public static String[] valuesRegax = new String[7];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		String A = null;
		try {
			tokenizer = new StringTokenizer(br.readLine());
			A = tokenizer.nextToken();
			B = tokenizer.nextToken();
		} catch(Exception e) {
			System.exit(0);
		}
		for(int i = 1; i <= 6; i++) {
			try {
				tokenizer = new StringTokenizer(br.readLine());
				keys[i] = tokenizer.nextToken();
				values[i] = tokenizer.nextToken();
				keysRegax[i] = keys[i].replace("+","\\+")
						.replace("(","\\(").replace(")","\\)");
				valuesRegax[i] = values[i].replace("+","\\+")
						.replace("(","\\(").replace(")","\\)");
			} catch(Exception e) {
				break;
			}
		}
		// 输入检查
//		System.out.println("A:" +A);
//		System.out.println("B:" +B);
//		int index =1;
//		while(values[index] != null) {
//			System.out.println("key:"+keys[index]+" value:"+values[index]);
//			index++;
//		}
		
		try {
			dfs(0,A);
		}catch(Exception e) {}
		if(steps == Integer.MAX_VALUE) {
			System.out.println("NO ANSWER!");
		}else {
			System.out.println(steps);
		}
	}
	private static void dfs(int index,String trace) {
//		System.out.println("trace["+index+"]:"+trace);
		if(index > 10 || index >= steps) {
			return;
		}
		if(trace.equals(B)) {
			steps = Math.min(steps, index);
			return;
		}
		for(int i = 1; i <= 6; i++) {
			if(keys[i] == null ||"".equals(trace)) {
				break;
			}
			if(trace.contains(keys[i])) {
				trace = trace.replaceFirst(keysRegax[i], values[i]); //+被当初正则表达式
				dfs(index+1,trace);
				trace = trace.replaceFirst(valuesRegax[i], keys[i]);
			}
		}
	}
}
