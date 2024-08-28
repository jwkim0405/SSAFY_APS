package 이진검색;

public class 이진검색01_이진검색_반복 {
	public static void main(String[] args) {
		int[] arr = {8, 9, 17, 21, 23, 35, 88, 369};
	
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				right = key - 1;
			 else
				left = mid + 1;	
		}
		
		
		
		return false;
	}
}
