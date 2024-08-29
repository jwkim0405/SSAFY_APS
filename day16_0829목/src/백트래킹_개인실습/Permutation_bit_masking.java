package 백트래킹_개인실습;

import java.util.Arrays;

public class Permutation_bit_masking {
	
	static int[] arr = {1, 2, 3};
	static int N = arr.length;
	static int[] result = new int[N];
	static int visited;
	
	public static void main(String[] args) {
		
		perm(0, 0);
		
	}

	static void perm(int idx, int visited) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀부분
		// 0 ~ N-1까지 볼거야.
		for(int i = 0; i < N; i++) {
			// 이미 방문했다면, continue;
			if ((visited & (1 << i)) > 0) continue;
			
			result[idx] = arr[i];
			perm(idx+1, (visited | (1 << i)));
		}
			
	}
	
}
