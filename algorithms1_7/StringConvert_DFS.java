package algorithms1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *  DFS�����ڲ�������
 *a aaaaa
 *a a112233445566778899
 *778899 a
 *112233 a
 *445 a
 *566 a
 *55 a
 *�³�ʱ
 *��ʱԭ���ڴ�������Ч����  a --> a112233445566778899 --> a112233445566778899112233445566778899
 */
// ���鱣��ӳ�䷽ʽ
// ����ӳ�����飬ɨ�赱ǰ�ַ��������ƥ������
// ȫ��StringBuilder ��������ǰ�ַ���
// DFS ���� 10 ����������������껹û�κοɴ﷽������� NO ANSWER! ��ÿ���ҵ�һ��·����ȡ����С��index��steps��
// ���Ӷȷ�����ÿ��DFS�ı����������Ϊ20��ͨ��ɨ�跽�����ַ����ڸ÷���Ͳ�DFS���ݹ��������Ϊ10������ջ���
// Ϊ�˿ɻ��ݣ�Ӧ��Ҫ����ÿһ�׵�String���
// �ַ�������1����ĳ���ַ����滻Ϊ����һ���ַ�����2���ж�ĳ���ַ����Ƿ����ַ�����
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
		// ������
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
				trace = trace.replaceFirst(keysRegax[i], values[i]); //+������������ʽ
				dfs(index+1,trace);
				trace = trace.replaceFirst(valuesRegax[i], keys[i]);
			}
		}
	}
}
