package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++)
		{
			int N = sc.nextInt();
			long[] price = new long[N];
			
			for (int i = 0; i < N; i++)
				price[i] = sc.nextInt();
			
			long[] max = new long[N];
			max[N-1] = price[N-1];
			
			int sum = 0;
			for (int i = N-2; i >= 0; i--) {
				max[i] = Math.max(price[i], max[i+1]);
				sum += max[i] - price[i];
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
