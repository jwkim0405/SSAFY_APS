package SWEA_1224_계산기3;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
		int N = sc.nextInt(); // 테스트 케이스의 길이
		String expression = sc.next(); // 테스트 케이스

		String postfix = infixToPostfix(expression); // 후위 표기식으로 변환
		System.out.println("#" + t + " " + evalPostfix(postfix));	 // 후위 표기식 계산
		
		}
	}

	// 중위표기식에서 후위표기식으로 변환
	static String infixToPostfix(String expression) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
		
		String postfix = ""; // 후위표기식 문자열
		Stack<Character> stack = new Stack<>(); // 연산자를 저장할 스택
		
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

//			System.out.println(postfix);
			if (c >= '0' && c <= '9') // 0~9 사이의 숫자인 경우
				postfix += c;
			else if (c == '(')	// 여는 괄호일 경우
				stack.push(c);
			else if (c == ')') { // 닫는 괄호일 경우
				char popItem = stack.pop();
				while(popItem != '(') { // 여는 괄호가 나오기 전까지 postfix에 연산자를 채워줌
					postfix += popItem;
					popItem = stack.pop();
				}
			} 
			
			else { // +, -, *, / 중 하나일 경우
				// 스택이 비어있지 않고
				// 더 우선순위가 낮은 연산자가 나올 때까지 pop
				while(!stack.isEmpty() && 
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				} 
				stack.push(c); // pop이 다 끝나면 push
			}
		}
		while(!stack.isEmpty())
			postfix += stack.pop();
		return postfix;
	}
	
	public static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (c >= '0' && c <= '9')
				stack.push(c - '0');
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result = 0;
				
				if (c == '+')
					result = num1 + num2;
				else if (c == '*')
					result = num1 * num2;
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	
	public static class Stack<E> {
		List<E> stack = new ArrayList<>();
		int top = -1;
		Stack() {}
		
		void push(E c) {
			top++;
			stack.add(c);
		}
		
		E pop() {
			E popItem = peek();
			stack.remove(top--);
			return popItem;
		}
		
		E peek() {
			return stack.get(top);
		}		
		
		boolean isEmpty() {
			return top == -1;
		}
	}
}