package 백트래킹;

import java.util.Arrays;

public class 순열03_방문체크 {
	static int[] nums;
	static int N;
	// 추가적인 공간 필요
	static boolean[] visited;
	static int[] result;

	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];		
		perm(0);
	} // main
	
	// idx: 현재 판단 위치
	static void perm(int idx) {
		// 기저조건
		if (idx == N)
			System.out.println(Arrays.toString(result));
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야 해!
			// 1. 사용했으면 continue;
			if(visited[i]) continue;
			// 2. 사용하지 않았다면 if () {요기 작성}
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false; // result는 덮어버리니까 굳이 초기화할 필요는 없음.
		}
		
	}

} // class	
