package SWEA_7465_창용마을무리의개수;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_disjoint {
	
	static int[] p; // 상호배타집합(각각의 root 위치 저장)
	static int N, M; // N: 사람 수, M: 간선 수
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 사람 수
			M = sc.nextInt(); // 간선 수
			p = new int[N+1];
			visited = new boolean[N+1];
			cnt = 0;
			makeSet(); // 먼저, 각각의 자기자신만 포함된 집합 생성

			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				if (findSet(A) != findSet(B))
					union(A, B);
			} // for m
			
			for (int i = 1; i <= N; i++) {
				boolean res = visited[findSet(i)];
				if (!res) {
					visited[findSet(i)] = true;
					cnt++;
				}
			} // for N
			
			System.out.println(Arrays.toString(p));
			System.out.println("#" + t + " " + cnt);
		} // for t
	} // main

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	
	static int findSet(int x) {
		// 방법 1
//		if (x != p[x])
//			return findSet(p[x]);
		
// 방법 2 => 루트에 계속 연결해주기
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
