package SWEA_7465_창용마을무리의개수;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_dfs {
	static int N, M;
	static ArrayList<Integer>[] p;
	static boolean[] visited;
	static int cnt; // 총 무리 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 사람 수
			M = sc.nextInt(); // 간선 수
			p = new ArrayList[N+1];
			for (int i = 1; i <= N; i++)
				p[i] = new ArrayList<>();
			
			visited = new boolean[N+1];
			cnt = 0;
			
			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				p[A].add(B);
				p[B].add(A);
			}
			
			
			
			for (int i = 1; i <= N; i++) {
				// 만약 방문 안 한 정점이 있다면, 탐색 && 무리+1
				if (!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	static void dfs(int idx) {
		// 방문 처리
		visited[idx] = true;
		
		for (int i = 0; i < p[idx].size(); i++) {
			int item = p[idx].get(i); // 연결된 정점
			
			// 방문 안 했다면 
			if(!visited[item]) {
				dfs(item);
			}
		}
	}
}
