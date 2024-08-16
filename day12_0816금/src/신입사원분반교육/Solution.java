package 신입사원분반교육;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N; // 학생 수
	static int min; // 최소인원
	static int max; // 최대인원
	static int[] score; // 학생별 점수
	static int[] classes; // 반 분류(부진, 보통, 우수)
	static int min_diff; // 인원 최소 차이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testcase 개수
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			min = sc.nextInt();
			max = sc.nextInt();
			score = new int[N];
			min_diff = 100;
			
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt(); // 학생별 점수 입력
			}
			
			// 점수 오름차순 정렬
			Arrays.sort(score);
			
			
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					classes = new int[3];
					for (int idx = 0; idx < N; idx++) {
						// 1. 부진 분반
						if (score[idx] < score[i]) classes[0]++;
							
						// 2. 보통 분반
						else if (score[idx] >= score[i] && score[idx] < score[j]) classes[1]++;
						
						// 3. 우수 분반
						else classes[2]++;
					}
					
					Arrays.sort(classes);
					
					if (classes[0] >= min && classes[0] <= max && classes[2] <= max) // 반별 최대최소인원 만족한다면, min_diff 비교
						min_diff = Math.min(min_diff, classes[2]-classes[0]);
				}
			}
			
			if (min_diff == 100)
				min_diff = -1;
			
			System.out.println("#" + t + " " + min_diff);
		}
	}
}
