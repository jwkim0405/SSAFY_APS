package 조합;

import java.util.Arrays;

public class 조합_01_재귀함수 {

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
		
		// ArrayIndexOutOfBoundsException 방지
		if (idx == N) return;
		
		
		// 재귀부분
		// 해당 idx 번째 재료를 사용했는지 안했는지
		sel[sidx] = ingredient[idx];
		combination(idx+1, sidx+1);
		
		//재료를 사용하지 않았음.
		combination(idx+1, sidx); // 햄버거의 실제 재료를 아직 뽑지 않았다.
	}

}
