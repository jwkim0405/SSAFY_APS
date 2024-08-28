package SWEA_1230_암호문3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	static LinkedList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			list = new LinkedList<>();
			
			// 원본 암호문 뭉치 -> list에 입력
			for (int i = 0; i < N; i++)
				list.add(sc.nextInt());
		
			int commandNum = sc.nextInt();
			
				
			for (int j = 0; j < commandNum; j++) {
				// *** char는 어떻게 입력받지?
				char command = sc.next().charAt(0);
				
				// Insert
				if (command == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int k = 0; k < y; k++) {
						list.add(x + k, sc.nextInt());
					}
				} 
				// Delete
				else if (command == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int k = 0; k < y; k++) {
						list.remove(x);
					}
					
				} 
				// Append
				else if (command == 'A') {
					int y = sc.nextInt();
					for (int k = 0; k < y; k++) {
						list.offer(sc.nextInt());
					}
				}	
				
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
		
		}
		
	}
}
