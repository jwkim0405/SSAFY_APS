package SWEA_1289_원재의메모리복구;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String memory;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++)
		{
			memory = sc.next();
			
			//String을 char배열로 변환
			char[] charArr = memory.toCharArray();
			int N = charArr.length;
			int cnt = 0;

			if (charArr[0] == '1') 
				cnt = 1;
			 else 
				 cnt = 0;
			 
				
			for (int i = N-1; i >= 1; i--) 
				if (charArr[i] != charArr[i-1])
					cnt++;
			
			// 결과 출력
			System.out.println("#" + t + " " + cnt);
			
		}
	}
}