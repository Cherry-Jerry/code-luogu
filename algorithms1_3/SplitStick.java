package algorithms1_3;



import java.io.IOException;
import java.util.Scanner;

public class SplitStick {
	public static long counter = 0;
	public static int[] a = new int[5000+1];
	public static int n;
	public static void main(String[] args)throws IOException{
		
//		Scanner sc = new Scanner(new File("C:\\Users\\10634\\Desktop\\in.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			a[sc.nextInt()]++;
		}
		sc.close();
		
		for(int i = 0; i < 5000+1;i++ ) {
			if(a[i] < 2) {
				continue;
			}else {
				int combine = 0;
				//combine += a[i];
				for(int j = 0; j < (i+1)/2; j++) {
					combine += a[j]*a[i-j];
					//System.out.println("combine1:"+combine);
				}
				if(i % 2 == 0) {
					combine += a[i/2]*(a[i/2]-1)/2;
					//System.out.println("combine2:"+combine);
				}
				//a[i] += 2;
				if(combine != 0) {
					counter += a[i]*(a[i]-1)/2 * combine;
				}
			}
		}
		
		int mod = (int)Math.pow(10, 9)+7;
		if(counter < mod) {
			System.out.println(counter);
		}else {
			System.out.println(Math.floorMod(counter,mod));
		}
	}

}
