package 그래프최소비용;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class 그래프최소비용01_크루스칼 {
	
	static class Edge {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}
		
	}
	
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 개수(정점의 시작 번호를 보고)
		int E = sc.nextInt(); // 간선의 개수
		
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.W - o2.W;
			}	
		}); // end sort
		
		p = new int[V];
		
		for (int i = 0; i < V; i++) {
			// makeSet(i);
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		
		for (int i = 0; i < E; i++) {
//			int x = edges[i].A;
//			int y = edges[i].B;
//			
//			// cycle이 발생하는지 검사를 해야 한다.
//			if(findSet(x) != findSet(y)) {
//				// 해당 블록에 들어왔다면...사이클이 아니라는 뜻
//				union(x, y);
//				ans += edges[i].W;
//				pick++;
//			}
			
			
			// # 2
			// 루트 2개 비교
			
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			
			
			
			if (px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
			
			if (pick == (V-1)) break;
		}
		System.out.println(ans);
		
	} // end main
	
	
	
	
	
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		// 해당 방식이 원래 우리가 알던 코드!
		if (x == p[x]) return x;
		return findSet(p[x]);
		
		// 위의 코드가 문제점이 있대... 똑같은 작업을 또 할 수 있어서 효율 down
		// 아래는 Path Compression을 적용한 코드
//		if (x!= p[x])
//			p[x] = findSet(p[x]);
//		return p[x];
	}
	
	
	static void union(int x, int y) {
		// x와 y가 대표자여야만 한다.
		p[findSet(y)] = findSet(x); // X그룹에 Y그룹을 넣는 것!
	}
	
	static String input = "7 11\r\n"+ "0 1 32\r\n"+ "0 2 31\r\n"+ "0 5 60\r\n"+ "0 6 51\r\n"+ "1 2 21\r\n"+ "2 4 46\r\n"+ "2 6 25\r\n"+ "3 4 34\r\n"+ "3 5 18\r\n"+ "4 5 40\r\n"+ "4 6 51\r\n"+ "";
}