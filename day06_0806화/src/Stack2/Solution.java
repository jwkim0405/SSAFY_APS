package Stack2;

import java.util.*;

// 계산기 만들기
public class Solution {
	public static void main(String[] args) {
		String infix = "(6+(5*2-8)/2)";
		
		String postfix = infixToPostfix(infix); // 후위표기식으르 변환
		System.out.println(postfix);
		
		// 후위 표기식 계산
		int result = evalPostfix(postfix);
		System.out.println(result);
		
	}
	
	// 중위표기식에서 후위표기식으로 변환
	public static String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<> ();
		String postfix = ""; // 반환할 후위표기식 초기화
		Map<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		map.put('(', 0);
		
		// infix 문자열의 길이만큼 반복
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i); // infix의 i번째 문자를 c 변수에 초기화
			
			if (c >= '0' && c <= '9')
				postfix += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') { // 닫는 괄호가 나오면, 여는 괄호가 나올 때까지 pop()
				char popItem = stack.pop();
			
				while(!(popItem == '(')) {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else { // 그 외에 연산자(+, -, *, /)가 나오는 경우
				
				// 우선순위가 낮은 연산자가 나올 때까지 pop, 그 이후에 push
				// 스택이 비어있지 않고
				// 스택의 top이 여는 괄호가 아니고,
				// 우선순위가 더 낮지 않을 때
				while(!(stack.isEmpty()) && 
						stack.peek() != '(' &&  
						map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop(); // pop!!
				} stack.push(c); // *** 디버깅하다 찾은 실수!
			}

		}
		while(!stack.isEmpty())
			postfix += stack.pop();
		
		
		return postfix;
	}

	// 후위 표기식 계산
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
				else if (c == '-')
					result = num1 - num2;
				else if (c == '*')
					result = num1 * num2;
				else if (c == '/')
					result = num1 / num2;
				
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
	// 스택 클래스 구현
	public static class Stack<E> {
		List<E> stack = new ArrayList<>();
		int top = -1;
		
		public Stack() {
			super();
		} // 기본 생성자
		
		// push 
		void push(E e) {
			top++;
			stack.add(e);
		}
		
		// pop
		E pop() {
			E popItem = peek();
			stack.remove(top--);
			return popItem;
		}
		// peek
		E peek() {
			return stack.get(top);
		}
		
		// isEmpty
		boolean isEmpty() {
			return top == -1;
		}
	}
	
}