package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int T = 1; T <= 10; T++) 
		{
			int test_case = sc.nextInt();
			int[][] arr = new int[100][100]; // 100 x 100 배열 선언

			for (int i = 0; i < 100; i++)
				for(int j = 0; j < 100; j++)
					arr[i][j] = sc.nextInt(); // 100 x 100 배열 값 할당
			
			int max = Math.max(row_col_max(arr), diagonal_max(arr)); // 행의 합, 열의 합, 대각선 합 중 가장 큰 값
			System.out.println("#" + test_case + " " + max);
		}

	}
	
	// 가로합, 세로합 중 최대값
	static int row_col_max(int[][] arr) {
		int max = 0;
	
		for (int i = 0; i < 100; i++) 
		{
			int row_sum = 0;
			int col_sum = 0;
			for(int j = 0; j < 100; j++) 
			{
				row_sum += arr[i][j];	// 각 행의 합 구하기
				col_sum += arr[j][i];	// 각 열의 합 구하기
			}
			
			if (max < row_sum)
				max = row_sum;	// max보다 크면 업데이트
			if (max < col_sum)
				max = col_sum;  // max보다 크면 업데이트
		}
		return max;
	}
	
	// 대각선 합 중 최대값
	static int diagonal_max(int[][] arr) {
		int right_down = 0;	// 오른쪽 아래로 내려가는 대각선
		int left_down = 0;	// 왼쪽 아래로 내려가는 대각선
		for (int i = 0; i < 100; i++) 
		{
			right_down += arr[i][i];
			left_down += arr[i][99-i];
		}
		return Math.max(right_down, left_down);
	}
}