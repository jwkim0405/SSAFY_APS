package 실습;

import java.util.Scanner;

// 거스름돈이 N원이라고 할 때
// 1, 4, 6원을 사용하여 거스름돈을 줄 수 있는 최소 개수 구하기

public class 거스름돈문제 {
	static int[] money = {1, 4, 6}; // 잔돈 종류
	static int[] dp; // i원일 때의 최소 개수들을 저장하는 dp 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 거스름돈
		dp = new int[N+1]; // dp 배열 객체 생성
		
		// 1원부터 N원까지를 탐색하며 dp배열에 최소 개수 저장
		for (int i = 1; i <= N; i++) {
			int minCnt= Integer.MAX_VALUE; // 최소 개수는 몇 개?
			for (int j = 0; j < money.length; j++) {
				if (i >= money[j]) { // i가 동전의 가격보다 크다면 비교
					minCnt = Math.min(minCnt, dp[i-money[j]] + 1);
				}
			}
			dp[i] = minCnt; // dp[i] 값 업데이트
		}
		// 결과 출력
		System.out.println(dp[N]);
	}
	
}
