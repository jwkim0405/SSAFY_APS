package 조합;

import java.util.Arrays;

public class 조합_01_재귀함수_반복문 {
	static String[] ingredient = {"상추", "패티", "치즈", "토마토"};
	static int N, R; // N: 재료의 수, R: 뽑고 싶은 재료의 수
	static String[] sel; //뽑은 재료들을 저장할 배열
	
	public static void main(String[] args) {
		// 4개 중에 2개를 뽑겠다.=
		N = ingredient.length; // 4
		R = 2;
		
		sel = new String[R];
		
		combination(0, 0);
	}
	
	// idx: 재료의 index
	// sidx: 뽑은 재료의 인덱스(몇 번째 재료인건지!! 뽑은 재료의 개수 - 1)
	
	public static void combination(int idx, int sidx) {
		// 기저조건
		if (sidx >= R) { // sidx == R 도 가능!
			// 모든 재료를 전부 다 뽑았다.
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 내가 이미 범위를 정해두고 반복문을 돌릴 것이니 인덱스 범위 벗어날 걱정 X
		// 재귀부분
		
		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = ingredient[i]; // 뽑았어요
			combination(idx+1, sidx+1);
		}
	}
}
