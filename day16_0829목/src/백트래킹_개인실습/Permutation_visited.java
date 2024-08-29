package 백트래킹_개인실습;

import java.util.Arrays;

public class Permutation_visited {
	static int[] arr = new int[] {1, 2, 3}; // Permutation할 배열
	static int N = arr.length;
	static boolean[] visited = new boolean[N]; // 각각의 permutation마다 방문 여부 체크
	static int[] result = new int[N]; // permutation 결과 담을 배열
	
	public static void main(String[] args) {
		
		
		perm(0);
		
	}
	
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀부분
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}
