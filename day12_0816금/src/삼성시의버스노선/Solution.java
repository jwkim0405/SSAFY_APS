package 삼성시의버스노선;

import java.util.Scanner;

public class Solution {
	static int N; // 버스 개수
	static int[] station;
	static int start;
	static int end;
	
	static int C;
	static int station_num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			station = new int[5001];
			for (int i = 0; i < N; i++) {
				start = sc.nextInt();
				end = sc.nextInt();
				
				for (int j = start; j <= end; j++)
					station[j]++;
			}
			
			C = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			for (int i = 0; i < C; i++) {
				station_num = sc.nextInt();
				sb.append(station[station_num]).append(" ");
			}
			System.out.println(sb);
		}
	}
}
