package 병합정렬;

import java.util.Arrays;

public class 병합정렬_나혼자힘으로 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	static int[] tmp = new int[N]; // 임시 저장할 배열
	
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		while(L <= mid && R <= right) {
			if (arr[L] <= arr[R])
				tmp[idx++] = arr[L++];
			else
				tmp[idx++] = arr[R++];
		}
		
		// 왼쪽 오른쪽 중에 한 줄이 끝나고, 남은 것들 담아주기
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}

		if (R <= right) {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		// 다시 원래 배열에 넣기
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}
