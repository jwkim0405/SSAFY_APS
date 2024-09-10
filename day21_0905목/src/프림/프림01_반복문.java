package 프림;

import java.util.Scanner;

public class 프림01_반복문 {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 번호 0번부터 시작
		int E = sc.nextInt(); // 간선의 수
		
		// 인접행렬 방식으로
		int[][] adjArr = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; // 무향
		} // 입력 끝
		
		boolean[] visited = new boolean[V]; // 해당 정점 뽑았어
		int[] p = new int[V]; // 내 부모는... 사용하지 않을 거라면 굳이 작성하지 않아
		int[] dist = new int[V]; // 아까 key라고 표현했던 선택한 간선의 가중치
		
		for(int i = 0; i < V; i++) {
			p[i] = -1; // ㅐ번 정점도 사용하니까...
			dist[i] = INF;
		}
		
		// 프림 제 2장: 시작 정점 결정
		dist[0] = 0;
		
		// 프림 제 3장: 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 체크 / 갱신
		for (int i = 0; i < V-1; i++) { // V번돌아도 괜찮아~
			int min = INF;
			int idx = -1;
			// 방문하지 않았으면서 가장 작은 값 가져와
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // 해당 반복문이 종료가 되면...idx는 가장 작은 값을 가지고 있어(방문X)

			visited[idx] = true;

			// 방문하지 않았고 갱신할 수 있으면 갱신해
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; // 필요시
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < V; i++) {
			ans += dist[i];
		}
		System.out.println(ans + " " + result);
	}	 

	
	
	
	
	
	
	
	
	
	
	
	static String input = "6 11\r\n"
			+ "0 1 4\r\n"
			+ "0 2 2\r\n"
			+ "0 5 25\r\n"
			+ "1 3 8\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 4 4\r\n"
			+ "3 0 3\r\n"
			+ "3 5 6\r\n"
			+ "4 3 5\r\n"
			+ "4 5 12\r\n"
			+ "";
	
	
	
	
	
	
	
	
	
	
	
	
	
	static String result = "정답일까? 오답일까? ㅋㅋ";
}