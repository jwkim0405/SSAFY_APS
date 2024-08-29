package SWEA_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
	static String[] map;
	static String input; // 입력값(U D L R S)
	static int H, W; // 맵의 높이, 너비
	static int r, c; // 전차의 위치
	static char dir; // 전차가 바라보는 방향
	static char[][] charMap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // testcase 개수
		
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt(); // 높이(행)
			W = sc.nextInt(); // 너비(열)
			
			map = new String[H];
			charMap = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				// 행별 맵 구성 입력
				map[i] = sc.next();
				
				// char형으로 변환
				charMap[i] = map[i].toCharArray(); 
				
				 // 전차의 위치 찾기
				if (map[i].contains("<")) {
					r = i;
					c = map[i].indexOf("<");
					dir = 'l';
				} else if (map[i].contains(">")) {
					r = i;
					c = map[i].indexOf(">");
					dir = 'r';
				} else if (map[i].contains("^")) {
					r = i;
					c = map[i].indexOf("^");
					dir = 'u';
				} else if (map[i].contains("v")) {
					r = i;
					c = map[i].indexOf("v");
					dir = 'd';
				}	
			}
			
			int N = sc.nextInt(); // 입력의 개수
			input = sc.next(); // N개의 입력
			for (int i = 0; i < N; i++) {
				// up
				if (input.charAt(i) == 'U') {
					dir = 'u';
					// 만약 평지라면,
					if (r-1 >= 0 && charMap[r-1][c] == '.')
						// 원래 위치 평지로 변경
						charMap[r--][c] = '.';
					charMap[r][c] = '^';
				} 
				// down
				else if (input.charAt(i) == 'D') {
					dir = 'd';
					// 만약 평지라면,
					if (r+1 < H && charMap[r+1][c] == '.')
						// 원래 위치 평지로 변경
						charMap[r++][c] = '.';
					charMap[r][c] = 'v';
				}
				// left
				else if (input.charAt(i) == 'L') {
					dir = 'l';
					// 만약 평지라면,
					if (c-1 >= 0 && charMap[r][c-1] == '.')
						// 원래 위치 평지로 변경
						charMap[r][c--] = '.';
					charMap[r][c] = '<';
				} 
				// right
				else if (input.charAt(i) == 'R') {
					dir = 'r';
					// 만약 평지라면,
					if (c+1 < W && charMap[r][c+1] == '.')
						// 원래 위치 평지로 변경
						charMap[r][c++] = '.';
					charMap[r][c] = '>';
				} 
				// shoot
				else if (input.charAt(i) == 'S') {
					shooting();
				}
			} // for (input N개 입력)
			
			
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(charMap[i][j]);
				}System.out.println();
			} 
		} // for tc
	} // main

	
	
	static void shooting() {
		// UP
		if (dir == 'u') {
			for (int i = r-1; i >= 0; i--) {
				char value = charMap[i][c];
				// 벽돌벽 만나면 평지로 바꾸고 끝내기
				if (value == '*') {
					charMap[i][c] = '.';
					break;
				// 강철벽 만나면 그냥 끝내기
				} else if (value == '#')
					break;
			}
		}
		// down
		else if (dir == 'd') {
			for (int i = r+1; i < H; i++) {
				char value = charMap[i][c];
				// 벽돌벽 만나면 평지로 바꾸고 끝내기
				if (value == '*') {
					charMap[i][c] = '.';
					break;
				// 강철벽 만나면 그냥 끝내기
				} else if (value == '#')
					break;
			}
		} 
		// left
		else if (dir == 'l') {
			for (int i = c-1; i >= 0; i--) {
				char value = charMap[r][i];
				// 벽돌벽 만나면 평지로 바꾸고 끝내기
				if (value == '*') {
					charMap[r][i] = '.';
					break;
				// 강철벽 만나면 그냥 끝내기
				} else if (value == '#')
					break;
			}
		} 
		// right
		else if (dir == 'r') {
			for (int i = c+1; i < W; i++) {
				char value = charMap[r][i];
				// 벽돌벽 만나면 평지로 바꾸고 끝내기
				if (value == '*') {
					charMap[r][i] = '.';
					break;
				// 강철벽 만나면 그냥 끝내기
				} else if (value == '#')
					break;
			}
		}
	}
}






