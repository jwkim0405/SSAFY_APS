package SWEA_1208_flatten;

import java.util.Arrays;
import java.util.Scanner;



public class Solution {
	static int[] height;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 총 10번의 Test Case
		for (int T = 1; T <= 10; T++) 
		{
			int N = sc.nextInt();	// 덤프 횟수
			
			int[] height = new int[100]; // 가로 길이 100 배열
			
			for (int i = 0; i < 100; i++) 
				height[i] = sc.nextInt(); // 배열 값 할당
			
			
//			countingSort();
			
			System.out.println("#" + T + " ");
		}
	}
	static void countingSort() {
		
	}
}