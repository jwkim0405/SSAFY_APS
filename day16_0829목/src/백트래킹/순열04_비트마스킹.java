package 백트래킹;

// 결과를 모아서 보려고 했을 때, 얕은 복사가 되지 않도록 주의!

import java.util.Arrays;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	// 추가적인 공간 필요
	static int[] result;

	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		result = new int[N];		
		perm(0, 0);
	} // main
	
	// idx: 현재 판단 위치
	// visited: 사용한 원소를 기록하기 위한 정수
	static void perm(int idx, int visited) {
		// 기저조건
		if (idx == N)
			System.out.println(Arrays.toString(result));
		
		// 재귀 부분
		for (int i = 0; i < N; i++) {
			// 사용하지 않은 원소를 가지고 만들어야 해!
			if((visited & (1 << i)) > 0) // 그 원소 썼어요
				continue;
			result[idx] = nums[i];
			perm(idx + 1, visited | (1 << i));
		}
		
	}

} // class	
