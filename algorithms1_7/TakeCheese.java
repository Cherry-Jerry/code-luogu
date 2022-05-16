package algorithms1_7;

import java.text.DecimalFormat;
import java.util.Scanner;
// 使用状态压缩DP算法解决该问题
// 读入坐标
// 计算任意两点距离
// 设F[i][j],表示状态为(i,j)，所有点链接的最小长度，其中i是当前所在点，
// j表示当前访问情况的二进制表示对应的十进制数值，比如 1001 表示访问了第0、第3个点，十进制表示为9
// 因为访问情况用一个int数字表示，运算耗时和空间大大压缩，所以称为状态压缩
// 最终输出F[?][1111 1111 1111 1111]
public class TakeCheese {
	public static double minSumDist = Double.MAX_VALUE;
	public static double[] x = new double[16];
	public static double[] y = new double[16];
	public static double[][] dist = new double[16][16];
	public static double[][] f;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		sc.close();
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				dist[i][j] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
			}
		}
//		for(int i = 0; i <= n; i++) {//检查输入情况
//			for(int j = 0; j <= n; j++) {
//		 		System.out.print(" "+dist[i][j]);
//			}
//			System.out.print("\n");
//		}
		f = new double[n+1][(1<<(n+1))];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < (1<<(n+1)); j++) {
				f[i][j] = Double.MAX_VALUE;
			}
		}
		for(int i = 1; i <= n; i++) {
			f[i][(1<<i)+1] = dist[0][i];
		}
		// DP
		for(int s = 1; s < (1<<(n+1)); s++){//遍历状态
			for(int i = 1; i <= n; i++) { //遍历终点
				if((s & (1<<i)) == 0) {
					continue;
				}
				for(int j = 1; j <= n; j++) {
					if(i == j) {
						continue; 
					}
					if((s & (1<<j)) == 0) {
						continue;
					}
//					System.out.println("i:"+i+" s:"+Integer.toBinaryString(s)+" s-(1<<i):"+Integer.toBinaryString((s - (1<<i))));
					f[i][s] = Math.min(f[i][s], f[j][s - (1<<i)]+ dist[i][j]);
//					System.out.println("f["+i+"]["+s+"]:"+f[i][s]);
				}
			}
		}
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		for(int i = 1; i <= n; i++) {
			minSumDist = Math.min(minSumDist, f[i][(1<<(n+1))-1]);
		}
		System.out.println(format.format(minSumDist));
//		for(int i = 0; i <= n; i++) {
//		for(int j = 0; j < (1<<(n+1)); j++) {
//			if(f[i][j] == Double.MAX_VALUE) {
//				System.out.print(" X");
//			}else {
//				System.out.print(" "+format.format(f[i][j]));
//			}
//		}
//		System.out.println();
//	}
	}
}
