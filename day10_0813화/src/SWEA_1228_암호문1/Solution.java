package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.Scanner;

// LinkedList를 이용해서 인덱스 x와 새로 넣는 첫 암호를 연결, 마지막 암호와 x+1 노드를 연결

public class Solution {
	
	static LinkedList<Integer> cryptogram;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++)
		{
			int len = sc.nextInt();
			cryptogram = new LinkedList<>();
			
			// 원본 암호문 입력
			for (int i = 0; i < len; i++)
				cryptogram.add(sc.nextInt());
			
			// 명령어 개수
			int N = sc.nextInt();
			
			// 명령어
			for (int i = 0; i < N; i++)
			{
				sc.next(); // Insert를 의미하는 I는 없어도 됨
				int x = sc.nextInt();
				int y = sc.nextInt();
				// x = 1이면, 0 -> 새로운 것1 -> 새로운 것2 -> 1
				
				for (int k = x; k < x + y; k++)
					cryptogram.add(k, sc.nextInt());
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " ");
			
			for (int i = 0; i < 10; i++)
				sb.append(cryptogram.get(i)).append(" ");
			
			System.out.println(sb);
		}
	}
}