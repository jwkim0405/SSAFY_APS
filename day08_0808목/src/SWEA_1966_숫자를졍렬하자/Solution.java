package SWEA_1966_숫자를졍렬하자;

import java.util.Scanner;

public class Solution {
	
	static int[] arr;
	static int N; // 각 배열의 길이
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// 테스트케이스 총 t번 수행
		for (int t = 1; t <= T; t++) {
			arr = new int[50];
			N = sc.nextInt();
			
			// N개의 값 배열에 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 삽입 정렬 메서드 이용하여 정렬
			insertionSort();
			
			// 정렬한 배열의 출력값을 저장할 배열 선언
			StringBuilder sb = new StringBuilder();
			
			//testcase 번호 출력
			sb.append("#").append(t).append(" ");
			
			for (int i = 0; i < N; i++)
				sb.append(arr[i]).append(" ");
			
			
			System.out.println(sb);
		}
	}
	
	static void insertionSort() {
		int j;
		for (int i = 1; i < N; i++) {
			int data = arr[i]; // 정렬되지 않은 배열의 첫 번째 원소
			for (j = i-1; j >= 0 && arr[j] > data; j--) {
				arr[j+1] = arr[j]; // arr[j]번째 값을 한 칸 오른쪽으로 밀어줄게요
			} arr[j+1] = data; // arr[j]값이 data보다 작아요. arr[j+1]값은 arr[j+2]로 이동해있어요. 그럼 arr[j+1]이 비겠죠? 그 자리에 data가 들어갑니다.
		}
	}
}