package 부분집합;

import java.util.Arrays;
import java.util.Iterator;

public class 부분집합_02_비트마스킹 {
	static String[] ingredient = {"단무지", "햄", "오이", "시금치"};
	static int N = 4; // 재료의 개수
	static int[] sel = new int[N]; // 해당 인덱스의 재료를 사용했는지 유무를 저장하는 배열
	public static void main(String[] args) {
		
		// 2**N만큼 반복한다.
//		for(int i = 0; i < (1 << N); i++) {
//			Arrays.fill(sel, 0);
//			for (int j = 0; j < N; j++) {
//				if ((i & (1 << j)) > 0) {
//					sel[N-1-j] = 1;
//				}
//			}
//			System.out.println(Arrays.toString(sel));
//		}
		
		for(int i = 0; i < (1 << N); i++) {
			// 재료 확인 for문 필요하다
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				// 0 0 0 1
				// 0 0 1 0
				// 0 1 0 0
				// 1 0 0 0 
				// & 연산자로 > 0 인지 확인!
				if ((i & (1 << j)) > 0) {
					sb.append(ingredient[j]).append(" ");
				}
			}
			
			// 재료 확인 끝
			System.out.println(sb);
		}
		
		
	}
}