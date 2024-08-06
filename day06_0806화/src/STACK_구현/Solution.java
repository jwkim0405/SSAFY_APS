package STACK_구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println("IsEmpty: " + Stack.isEmpty());
		stack.push(1);
		stack.push(5);
		stack.push(3);
		System.out.println(stack.stack);
		System.out.println("pop: " + stack.pop());
		
		System.out.println(stack.stack);
		System.out.println("peek: " + stack.peek());
	}
	
	// Stack의 메서드를 모아놓은 클래스
	public static class Stack {	
		// 스택으로 사용할 ArrayList
		static List<Integer> stack = new ArrayList<>();
		static int top = -1;
		
		public Stack() {}

		void push(int num) {
			top++;
			stack.add(num);
		}
		
		int pop() {
			int popItem = peek();
			stack.remove(top--);
			return popItem;
		}
		
		int peek() {
			return stack.get(top);
		}
		
		static boolean isEmpty() {
			return top == -1;
		}
		
	}
}
