package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // 테스트케이스 개수
		
		for (int t = 1; t <= testCase; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.print("#" + t + " ");

			int max = Math.max(N, M); // N, M 중 max값 저장
			int min = Math.min(N, M); // N, M 중 min값 저장
			for (int num = min + 1; num <= max + 1; num++)
				System.out.print(num + " "); // min+1부터 max+1까지 최대 확률로 나옴.
			System.out.println();
			}
	}
}