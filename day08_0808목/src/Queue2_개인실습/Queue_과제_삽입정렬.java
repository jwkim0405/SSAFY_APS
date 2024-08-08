package Queue2_개인실습;

import java.util.Arrays;

public class Queue_과제_삽입정렬 {
	public static void main(String[] args) {
		
		int[] arr = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		
		// 배열의 크기
		int N = arr.length;
		
		// 삽입 정렬
		// i: 정렬되지 않은 집합의 첫번째 원소
		int j;
		
		// ** j값을 for문 밖에서 선언한다는 아이디어
		// ** if~else문이 아니라 for문의 조건식 자리에 &&를 넣어 구현할수도 있음.dnjsg
		for (int i = 1; i < N; i++) {
			int data = arr[i];
			for (j = i-1; j >= 0; j--) {
				if (arr[j] > data) // 정렬되지 않은 집합의 첫번째 원소인 data보다 값이 크다? => 오른쪽으로 한 칸 밀어!
					arr[j+1] = arr[j];
				else // 데이터가 더 크다! => 너 그 자리에 그대로 있어.(ex.arr[3]) 너+1 인덱스 값(arr[4]->arr[5])이 한 칸 이동하면서 빈 자리(arr[4])에 내가 들어갈게!
					break; 
			} arr[j+1] = data;
		}
		System.out.println(Arrays.toString(arr));
	}
}
