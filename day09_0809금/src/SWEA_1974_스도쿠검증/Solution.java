package SWEA_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		int testCase  = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int[][] sudoku = new int[9][9];
			make_sudoku(sudoku);
			
		// 각각의 스도쿠 내에서 1~9가 있는지 검증
			
			
		// 스도쿠 경계에서 서로 겹치는 게 없는지 확인
//		for (int i = )
			
		}
	}
	
	// 스도쿠 입력받기
	static void make_sudoku(int[][] sudoku) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 0; j++)
				sudoku[i][j] = sc.nextInt();
	}
}
