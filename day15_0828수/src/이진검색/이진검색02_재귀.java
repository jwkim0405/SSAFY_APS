package 이진검색;

import java.util.Arrays;

public class 이진검색02_재귀 {
	static int[] arr = {8, 9, 17, 21, 23, 35, 88, 369};
	static int key = 369;
	
	public static void main(String[] args) {
		System.out.println(binarySearch(0, arr.length-1)); // 존재함
		System.out.println(Arrays.binarySearch(arr, key)); // 인덱스
	}
	
	static boolean binarySearch(int left, int right) {
		// 기저조건
		if (left > right) return false;
		
		// 재귀부분
		int mid = (left + right) >> 1;
		
		
		// 같다면
		if (arr[mid] == key) return true;
		// 중앙값이 더 크다면
		else if (arr[mid] > key)
			return binarySearch(left, mid - 1);
		// 중앙값이 작다면
		else
			return binarySearch(mid + 1, right);		
	}
}
