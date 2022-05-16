package algorithms1_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CommunicateWithMartian {
	public static int cut = 10;
	public static int[] origin;
	public static int[] result;
	public static boolean[] using;
	public static int[] remember = new int[cut+1];
	public static int N; 
	public static int M; 
	public static boolean firstTime = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		if(N < cut) {
			origin = new int[N+1];
			result = new int[N+1];
			using = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				origin[i] = Integer.parseInt(tokenizer.nextToken());
			}
			dfs(1);
		}else {
			origin = new int[cut+1];
			result = new int[cut+1];
			using = new boolean[cut+1];
			for(int i = 1; i <= N-cut; i++) {
				System.out.print(tokenizer.nextToken()+" ");
			}
			for(int i = 1; i <= cut; i++) {
				origin[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			for(int i = 1; i <= cut; i++) {
				remember[i] = origin[i];
			}
			Arrays.sort(remember);
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
			for(int i = 1; i <= cut; i++) {
				map.put(remember[i],i);
			}
			for(int i = 1; i <= cut; i++) {
				origin[i] = map.get(origin[i]);
			}	
//			System.out.println(); 
//			System.out.println("remember"); 
//			for(int j = 1; j <= cut; j++) {
//				System.out.print(remember[j]+" "); 
//			}
//			System.out.println(); 
//			System.out.println("origin"); 
//			for(int j = 1; j <= cut; j++) {
//				System.out.print(origin[j]+" "); 
//			}
//			System.out.println(); 
			N=cut;
			dfs(1);
		}
		

	}
	private static void dfs(int index) {

		if(index > N) {
			if(firstTime) {
					for(int i = 1; i <= N; i++) {
						origin[i] = 1;
					}
				firstTime = false;
			}
			if(M <= 0) {
				if(N < cut) {
					for(int i = 1; i <= N; i++) {
						System.out.print(result[i]+" ");
					}
				}else {
//					System.out.println("result"); 
//					for(int j = 1; j <= cut; j++) {
//						System.out.print(result[j]+" "); 
//					}
//					System.out.println(); 
					// 原出错原因：前面的改变影响后面

					for(int i = 1; i <= cut; i++) {
						result[i] = remember[result[i]];
					}
					for(int i = 1; i <= cut; i++) {
						System.out.print(result[i]+" ");
					}
				}
				N = -1;
			}
			M--;
			return;
		}
		
	for(int i = origin[index]; i <= N; i++) {
		if(!using[i]) {
			using[i] = true;
			result[index] = i;
			dfs(index+1);
			using[i] = false;
		}
	}
		
	}
}
