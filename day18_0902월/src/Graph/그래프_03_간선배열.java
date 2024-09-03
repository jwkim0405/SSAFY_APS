package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {

	static class Edge {
		int A, B, W; // 시작, 끝, 가중치

		public Edge(int a, int b, int w) {
			A = a;
			B = b;
			W = w;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// V, E의 개수를 준다.
		
		int V = sc.nextInt(); // 정점의 개수(0 or 1로 시작한다.)
		int E = sc.nextInt(); // 간선의 개수
		
		Edge[] edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		
		
	}
}