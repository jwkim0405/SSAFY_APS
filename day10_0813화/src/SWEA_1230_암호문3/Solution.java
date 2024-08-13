package SWEA_1230_암호문3;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	static LinkedList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++)
		{
			int len = sc.nextInt();
			list = new LinkedList<>();
			
			for (int i = 0; i < len; i++)
				list.add(sc.nextInt());
			
			int N = sc.nextInt(); // 명령어 개수
			for (int i = 0; i < N; i++)
			{
				String command = sc.next();
				
				if (command.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = x; j < x + y; j++) {
						list.add(j, sc.nextInt());
					}
				} else if(command.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					for (int j = x+y-1; j >= x; j--) {
						list.remove(j);
					} 
				} else if(command.equals("A")) {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.add(sc.nextInt());
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++)
				sb.append(list.get(i)).append(" ");
			
			System.out.println(sb);
			
			
		}
		
	}
}