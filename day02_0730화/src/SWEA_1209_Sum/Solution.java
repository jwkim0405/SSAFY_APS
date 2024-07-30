package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();	// 테스트 케이스 번호
			int[][] ary = new int[100][100];	// 100x100 배열 생성

			int sum = 0;	// sum값 받을 변수
			int max = 0;
			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++)
					ary[i][j] = sc.nextInt();
			
			for (int i = 0; i < 100; i++) {
				int h_sum = 0;
				int v_sum = 0;
				
				for (int j = 0; j < 100; j++) {
					h_sum += ary[i][j];	// 가로 합
					v_sum += ary[j][i];	// 세로 합
				}
				
				if (h_sum > max) max = h_sum;	// 최대값 비교
				
				if (v_sum > max) max = v_sum;	// 최대값 비교
			}
			
			int right_down = 0;	// 오른쪽 아래 방향 대각선
			int left_down = 0;	// 왼쪽 아래 방향 대각선
			for (int i = 0; i < 100; i++) {
				right_down += ary[i][i];
				left_down += ary[99-i][i];
			}
			
			int res = Math.max(max, Math.max(right_down, left_down));	// 최대값 비교
			
			System.out.println("#" + t + " " + res);
		}
	}
}