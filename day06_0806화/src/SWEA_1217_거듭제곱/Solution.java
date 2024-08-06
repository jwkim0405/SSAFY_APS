package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int testCase = sc.nextInt(); // 테스트케이스 번호
			int base = sc.nextInt(); // 밑 
			int exp = sc.nextInt(); // 지수
			int result = exponent(base, exp); // base^exp 계산하는 재귀 메서
			
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	static int exponent(int base, int exp) {
		if (exp == 1)
			return base; // base case: 재귀 호출에서 빠져나가기 위한 조건
		return base * exponent(base, exp-1); // recursive case: 자신을 호출하는 부분(base case로 유도)
	}
}