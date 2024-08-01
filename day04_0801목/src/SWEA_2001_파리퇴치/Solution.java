package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	
	static int N;
	static int M;
	static int[][] fly;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			fly = new int[N][N];
			
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					fly[i][j] = sc.nextInt();
			int n = sc.
			int max = 0;
			// 시작점 (i,j)의 사각형
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = sum(i,j);
					if (max < sum)
						max = sum;
				}
			}
					
			System.out.println("#" + t + " " + max);
		}
	}
	
	// MxM 크기의 사각형 합 구하는 method
	static int sum(int i, int j) {
		int sum = 0;
		// M x M 크기의 값의 합
		for (int p = 0; p < M; p++)
			for (int q = 0; q < M; q++)
				sum += fly[i+p][j+q]; 
		
		return sum;
	}
}