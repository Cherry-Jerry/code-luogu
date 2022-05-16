package algorithms1_7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * ˫��BFS���������� max=6 ���ؽ���������������������ڷ�����������г��֣����ս�����������+�������
 * @author 10634
 * Ҫ�Լ�д �����ַ����ĺ��� TODO KMP�ַ���ƥ�䣬 AC�Զ�����ѧϰ��
 */
class Node{
	String str;
	int step;
	public Node(String str, int step) {
		super();
		this.str = str;
		this.step = step;
	}
	@Override
	public String toString() {
		return "Node [str=" + str + ", step=" + step + "]";
	}
	
}
public class StringConvert_BFS {
	public static int ans = Integer.MAX_VALUE; 
	public static String[] keys = new String[7];
	public static String[] values = new String[7];
	public static String[] keysRegax = new String[7];
	public static String[] valuesRegax = new String[7];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		String A = null;
		String B = null;
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
//		while(index<=6 && values[index] != null) {
//			System.out.println("key:"+keys[index]+" value:"+values[index]);
//			index++;
//		}
		
		HashMap<String,Integer> memoryA = new HashMap<>();
		HashMap<String,Integer> memoryB = new HashMap<>();
		LinkedList<Node> queueA = new LinkedList<Node>();
		LinkedList<Node> queueB = new LinkedList<Node>();
		Node nodeA = new Node(A,0);
		Node nodeB = new Node(B,0);
		queueA.add(nodeA);
		queueB.add(nodeB);
		memoryA.put(nodeA.str, nodeA.step);
		memoryB.put(nodeB.str, nodeB.step);
		while(!queueA.isEmpty()) {
			nodeA = queueA.removeFirst();
//			System.out.println("nodeA:"+nodeA);
			for(int i = 1; i <= 6; i++) {
				if(keys[i] == null || "".equals(keys[i]) || nodeA.step > 10 ) {
					break;
				}
				int index = 0;
				String prefix = nodeA.str.substring(0,index);
				String suffix = nodeA.str.substring(index);
				while(suffix.contains(keys[i])) {
					Node nextNode = new Node(
							prefix+suffix.replaceFirst(keysRegax[i], values[i]),
							nodeA.step+1);
					index += suffix.indexOf(keys[i], 0) + keys[i].length();
					prefix = nodeA.str.substring(0,index);
					suffix = nodeA.str.substring(index);
					
					if(memoryA.get(nextNode.str) == null) {
						memoryA.put(nextNode.str, nextNode.step);
						queueA.add(nextNode);
					}
					if(memoryB.get(nextNode.str) != null){																
						ans = Math.abs(nextNode.step - memoryB.get(nextNode.str));
						queueA.clear();
						queueB.clear();
					}
				}			
			}
			if(!queueB.isEmpty()) {
				nodeB = queueB.removeFirst();
//				System.out.println("nodeB:"+nodeB);
				for(int i = 1; i <= 6; i++) {
					if(values[i] == null || "".equals(values[i]) || nodeB.step > 10) {
						break;
					}
					
					int index = 0;
					String prefix = nodeB.str.substring(0,index);
					String suffix = nodeB.str.substring(index);
					while(suffix.contains(values[i])) {
						Node nextNode = new Node(
								prefix+suffix.replaceFirst(valuesRegax[i], keys[i]),
								nodeB.step-1);
						index += suffix.indexOf(values[i], 0) + values[i].length();
						prefix = nodeB.str.substring(0,index);
						suffix = nodeB.str.substring(index);
						
						if(memoryB.get(nextNode.str) == null) {
							memoryB.put(nextNode.str, nextNode.step);
							queueB.add(nextNode);
						}
						if(memoryA.get(nextNode.str) != null){																
							ans = Math.abs(nextNode.step - memoryA.get(nextNode.str));
							queueA.clear();
							queueB.clear();
						}
					}	
				}
			}
		}
		if(ans == Integer.MAX_VALUE || ans > 10) {
			System.out.println("NO ANSWER!");
		}else {
			System.out.println(ans);
		}
	}
}
