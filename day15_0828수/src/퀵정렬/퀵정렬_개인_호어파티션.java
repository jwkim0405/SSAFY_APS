package 퀵정렬;

import java.util.Arrays;

public class 퀵정렬_개인_호어파티션 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length;
	
	public static void main(String[] args) {
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[left]; // 가장 왼쪽 값을 pivot으로
		int L = left+1;
		int R = right;
		while (L <= R) {
			while(L <= R && arr[L] <= pivot) {
				L++;
			}
			while(L <= R && arr[R] >= pivot) {
				R--;
			}
			// swap
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// swap
		int tmp = arr[R];
		arr[R] = arr[left];
		arr[left] = tmp;
		
		return R;
		
	}
}
