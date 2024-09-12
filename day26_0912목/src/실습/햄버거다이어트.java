package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트 {
	
	static int N; // 재료 개수
	static int L; // 제한 칼로리
	static int[] scores;
	static int[] cals;
	static int[][] dp; // 최대 점수 dp
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N+1];
			cals = new int[N+1];
			dp = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) {
				scores[i] = sc.nextInt(); // 맛 점수
				cals[i] = sc.nextInt(); // 칼로리
			}
			
			// ========== 입력 완료 ===========
			
			
			// 1~i까지의 재료 사용하겠다!
			for (int i = 1; i <= N; i++) {
				// 1~L칼로리까지
				for (int j = 1; j <= L; j++) {
					// 현재 칼로리가 재료의 칼로리보다 커지면
					if (j >= cals[i]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-cals[i]] + scores[i]); 
					}						
				}
			}
			
			System.out.println(dp[N][L]);
			

		}
	}
	
}
