package SWEA_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	
	static int[] data;
	static int N, K; // N: 숫자 개수, K: sum값
	static int cnt; // sum이 K인 조합 경우의 수
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // testcase 개수
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 숫자 개수
			K = sc.nextInt(); // sum 값
			cnt = 0;
			
			data = new int[N]; // 숫자 배열 객체 생성
			
			for (int i = 0; i < N; i++)
				data[i] = sc.nextInt(); // 값 입력
			
			// 1 ~ 2**N까지 숫자에 대해 비트연산
			for (int i = 1; i < (1 << N); i++) {
				// 0~N-1자리까지 보겠다!
				int sum = 0;
				for (int j = 0; j < N; j++) {
					// 현재 비트연산할 숫자 & 각 자리(0001, 0010, 0100, 1000)와 비교 
					if ((i & (1 << j)) > 0)
						sum += data[j]; // j 혹은 N-1-j로 해도 같은 결과!
				}
				if (sum == K) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
		
		
	}
	
}