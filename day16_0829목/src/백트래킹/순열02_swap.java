package 백트래킹;

import java.util.Arrays;

public class 순열02_swap {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		
		perm(0);
	} // main
	
	// idx: 현재 판단 위치
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		// 재귀부분
		for (int i = idx;i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); // 다음 과정을 위해서 원상 복구
		}
	}
	
	
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a]= nums[b];
		nums[b] = tmp;
	}
} // class	
