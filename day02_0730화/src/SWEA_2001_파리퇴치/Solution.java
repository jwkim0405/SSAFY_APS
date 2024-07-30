package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // test case 개수
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			// 파리는 영어로 fly입니다.
			// 매미는 영어로 cicada입니다.
			int[][] fly = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					fly[i][j] = sc.nextInt();
			
			int max = 0;
	
			for (int i = 0; i < n - m + 1; i++) 
				for (int j = 0; j < n - m + 1; j++) 
					max = Math.max(max, sum(fly, m, i, j));
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	// m x m 배열 sum
	static int sum(int[][] arr, int m, int p, int q) {
		int sum = 0;
		for (int i = 0; i < m ; i++)
			for (int j = 0; j < m; j++)
				sum += arr[p+i][q+j];
		return sum;
	}
}