package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// V, E의 개수를 준다.
		
		int V = sc.nextInt(); // 정점의 개수(0 or 1로 시작한다.)
		int E = sc.nextInt(); // 간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt(); // 두 개의 정점이 주어진다.
			int W = sc.nextInt(); // 가중치가 있다면 값은 3개
		
			for (int j = 0; j < V; j++)
				adjList[j] = new ArrayList<>();
			
			// 가중치를 같이 저장하고 싶다면 1. 클래스를 정의해서 넣던지
			// 2. int[] 이용해서 넣던지
			adjList[A].add(B);
			adjList[B].add(A);
			
		}
		
		// 인접행렬 vs 인접리스트 (장단점 정도는 알고 있자!)
		// 정점 100만개 간선 100개
		// 인접리스트를 쓰자! 인접행렬은 100만 x 100만 배열을 만들어야 함
		
		// A와 B가 연결되어 있나요? 라는 걸 찾을 때 인접행렬이 좋음!
		// 인접리스트는 연결되었는지 확인해보기 위해서는 돌아와야 함
	}
}