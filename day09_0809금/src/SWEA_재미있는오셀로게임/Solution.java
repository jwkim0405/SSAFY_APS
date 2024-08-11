package SWEA_재미있는오셀로게임;

import java.util.Scanner;

public class Solution {
	static int[][] board;
	static int N; 
	// for문을 돌며 흑돌과 흰돌의 개수 카운트
	static int cnt_black = 0;
	static int cnt_white = 0;
	static int res = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++)
		{
			N = sc.nextInt(); // 한 변의 길이
			int M = sc.nextInt(); // 두 플레이어가 돌을 놓는 총 횟수
			
			// 돌을 놓을 2차원 배열 생성
			// 배열의 값 => 1: 흑돌, 2: 백돌
			// 위치를 (1, 1) 입력하면 인덱스(0, 0)에 저장
			// row부분을 x부분으로. col부분을 y부분으로.
			board = new int[N][N]; 
			
			// 정가운데 4개의 돌의 종류 배열에 할당
			setting_board();
			

			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt(); // x 양의 방향으로 가는 길이
				int y = sc.nextInt(); // y 양의 뱡항으로 가는 길이
				int color = sc.nextInt(); // 어떤 색 돌을 놓을 것인지
				
				// 입력한 위치에 돌의 색을 할당
				board[x-1][y-1] = color; 
				
				// 델타 탐색을 통해 바뀌는 곳 찾아서 바꾸기
				play(x-1, y-1, color);
				
				cnt_black = 0;
				cnt_white = 0;
				
				for (int p = 0; p < N; p++) {
					for (int q = 0; q < N; q++) {
						if (board[p][q] == 1) cnt_black++; // 값이 1이면 흑돌
						else cnt_white++; // 값이 2이면 흰돌
					}
				}	
			}
			System.out.println("#" + t + " " + cnt_black + " " + cnt_white);
		}
	}
	
	// 메서드: 정가운데 4개의 돌의 종류 배열에 할당
	static void setting_board() {
		int mid = N / 2; // 배열 값의 절반
		board[mid - 1][mid - 1] = 1; // 흑돌
		board[mid - 1][mid] = 2;     // 백돌
		
		board[mid][mid - 1] = 2; // 백돌
		board[mid][mid] = 1;     // 흑돌
	}
	
	static void play(int x, int y, int color) { // x, y는 인덱스 값
		// '상우하좌' 순서로 대각선 포함하여 8곳 델타 탐색
		int[] dx = {0, 1, 1, 1, 0, -1,-1, -1};
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		for (int i = 0; i < 8; i++) {
			
			int nx = x + dx[i]; // x-1에서 상하좌우대각선
			int ny = y + dy[i]; // y-1에서 상하좌우대각선
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 인덱스 범위 내에서
				if (board[nx][ny] != board[x][y]) { // 만약 내가 바꾼 값의 이웃 값이 서로 다른 값이면서
					// 해당 방향으로 더 가서 같은 값이 있는지 비교!!
					play(nx, ny, color);
					if (res == 1)
						board[nx][ny] = color;
					
				}
				else { // 값이 같다!
					res = 1;
					return;
				}
			} else 
				continue;
		}
	}
}
