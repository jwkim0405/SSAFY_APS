package 백트래킹_개인실습;

import java.util.Arrays;

public class Permutation_swap {
	static int[] arr = new int[] {0, 1, 2};
	static int N = arr.length;
	
	public static void main(String[] args) {
		perm(0);
	}
	
	
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		// 재귀부분
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
		
	}
	
	
	static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
