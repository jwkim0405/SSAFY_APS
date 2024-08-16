package SWEA_2930_힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N; // 연산 수행 횟수
	static int operation; // 연산 종류 저장 (1, 2)
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); 
			StringBuilder sb = new StringBuilder(); // 결과 문자열 저장
			sb.append("#" + t + " ");
			pq = new PriorityQueue<>(Collections.reverseOrder());
			
			for (int i = 0; i < N; i++) {
				operation = sc.nextInt();

				// 삽입 연산
				if (operation == 1) { 
					int item = sc.nextInt();
					pq.offer(item);
				}
				
				// 삭제 연산
				else if (operation == 2) {
					if (pq.isEmpty())
						sb.append(-1).append(" ");
					else sb.append(pq.poll()).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
