package SWEA_10726_이진수표현;

import java.util.Scanner;

public class Solution {
	static String result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			result = "ON";
			
			for (int i = 0; i < N; i++) {
				if((M & (1 << i)) == 0) {
					result = "OFF";		
					break;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
