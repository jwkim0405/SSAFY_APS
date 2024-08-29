package 백트래킹;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	
	static int N, L; // N: 재료의 개수, L: 제한 칼로리
	static int[] cals;
	static int[] scores;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			cals = new int[N];
			scores = new int[N];
			
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			} // input 끝
			
			ans = 0;
			
			makeBurger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
			
		} // tc
		

		
	} // main
	
	
	
	static void makeBurger(int idx, int sumScore, int sumCal) {
		// 내가 중간결과를 들고 다니는데, 이미 칼로리가 넘어버려! return.
		if (sumCal > L)
			return;
		
		// 기저조건
		if (idx == N) {
			// 모든 재료를 전부 다 고려했어!
			// 베스트인지 아닌지 판단해라!
			if (sumCal <= L && ans < sumScore)
				ans = sumScore;
			return;
		}
		
		// 재귀부분
		// 1. idx 재료 사용했다!
		// parameter로 score, cal을 넣어주면 원상복구할 필요가 없다!
		makeBurger(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);
		
		// 2. 재료를 사용하지 않았다!
		makeBurger(idx + 1, sumScore, sumCal);
		
	}
	
}
