package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트 {
	
	static int N; // 재료 개수
	static int L; // 제한 칼로리
	static int[] scores;
	static int[] cals;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N+1];
			cals = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt(); // 맛 점수
				cals[i] = sc.nextInt(); // 칼로리
			}
			
			// ========== 입력 완료 ===========
			for (int i = 1; i)
			

		}
	}
	
}
