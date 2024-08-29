package SWEA_2806_NQueen_구현중;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int result; // 가능한 개수
	static int N; // NxN 체스판
	static boolean[] visited;
	static boolean[] diagonal;
	static boolean[][] map;
	
	
	public static void main(String[] args) {
		// N x N 체스판이라면, 
		// 재귀 돌려서 N+1번째 줄까지 가면 멈추고, 개수 cnt
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			result = 0; // tc별 개수 초기화
			visited = new boolean[N+2];
			diagonal = new boolean[N+2];
			map = new boolean[N+2][N+2];
			
			Nqueen(1); 
			
			// 결과 출력
			System.out.println("#" + tc + " " + result);
		}
	}

	static void Nqueen(int row) {
		// 기저조건
		if (row == N+1) {
			result++;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j])
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		// 재귀부분
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && !diagonal[Math.abs(i-row)] && !map[row-1][i-1] && !map[row-1][i] && !map[row-1][i+1]) {
				// 왼쪽 절대값
				map[row][i] = true;
				visited[i] = true;
				diagonal[Math.abs(i-row)] = true; // 대각선 정보 저장
				Nqueen(row+1);
				map[row][i] = false;
				visited[i] = false;
				
				diagonal[Math.abs(i-row)] = false; // 대각선 정보 저장
			}
		}
	}
}
