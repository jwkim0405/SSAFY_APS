package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<Integer> arr = new ArrayList<> ();
	static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // 테스트케이스 개수 입력
		
		for (int t = 1; t <= TC; t++) {
			int K = sc.nextInt(); // 몇 개의 숫자를 받을지 입력(0 포함)
			top = -1;
			
			for (int j = 0; j < K; j++) {
				int num = sc.nextInt();
				
				
				// if: 숫자가 0이면 pop
				if (num == 0) pop();
				// else:(0이 아니면) 숫자를 배열에 넣는다.
				else push(num);
			}
			
			int sum = 0; // 배열의 합 구하기
			
			// list에 남아있는 값들의 합 구하기
			for (int i = 0; i < arr.size(); i++)
				sum += arr.get(i);
			
			System.out.println("#" + t + " " + sum);
			arr.clear(); // list 비우기
		}
	}
	
	
	// stack의 push 연산
	static void push(int num) {
		top++;
		arr.add(num);
	}

	// stack의 pop 연산
	static int pop() {
		int popInteger = arr.get(top);
		arr.remove(top--);
		return popInteger;
	}
}	