package SWEA_1288_새로운불면증치료법;

import java.util.Scanner;

public class Solution {
	static boolean[] number;
	static int cnt;
	static int resN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			number = new boolean[10]; // 0~9까지 각 자리 수가 채워졌는지!
			cnt = 0; // 0~9까지 채워진 개수
			
			int i = 1;
			while(cnt < 10) {
				int num = N * i;
				while(num != 0) {
					if (!number[num%10]) {
						number[num%10] = true;
						cnt++;
						if (cnt == 10)
							resN = i;
					}
					num /= 10;
				}				
				i++;
			}
			
			System.out.println("#" + t + " " + N * resN);
		}
	}
}
