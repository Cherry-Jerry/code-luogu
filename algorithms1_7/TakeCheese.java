package algorithms1_7;

import java.text.DecimalFormat;
import java.util.Scanner;
// ʹ��״̬ѹ��DP�㷨���������
// ��������
// ���������������
// ��F[i][j],��ʾ״̬Ϊ(i,j)�����е����ӵ���С���ȣ�����i�ǵ�ǰ���ڵ㣬
// j��ʾ��ǰ��������Ķ����Ʊ�ʾ��Ӧ��ʮ������ֵ������ 1001 ��ʾ�����˵�0����3���㣬ʮ���Ʊ�ʾΪ9
// ��Ϊ���������һ��int���ֱ�ʾ�������ʱ�Ϳռ���ѹ�������Գ�Ϊ״̬ѹ��
// �������F[?][1111 1111 1111 1111]
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
//		for(int i = 0; i <= n; i++) {//����������
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
		for(int s = 1; s < (1<<(n+1)); s++){//����״̬
			for(int i = 1; i <= n; i++) { //�����յ�
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
