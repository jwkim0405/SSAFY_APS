package LinkedStack;

import java.util.LinkedList;

class Node {
	String data;
	Node link;
}

class Stack {
	Node head;
	int size;
	
	Stack() {
		head = new Node();
	}
	
	
	// 삽입
	// *** push 메서드 다시 짜보기
	// head.link가 null을 가리킬 때를 따로 고려해줘야 함.
	// head.link가 null인데 그 null을 curr에 저장해놓고, curr = newNode를 하면 null에다가 저장하는 느낌?
	void push(String data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (head.link == null) {
			head.link = newNode;
		} else {
			Node curr = head.link;
			while(curr.link != null) {
				curr = curr.link;
			} curr.link = newNode;
		}
		size++;
//		Node curr = head.link;
//		while (curr != null) {
//			curr = curr.link;
//		}
//		curr = newNode;
		
	} 
	
	// 삭제
	String pop() {
		if (size == 0) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		
		Node curr = head;
		while(curr.link.link != null) {
			curr = curr.link;
		}
		String popItem = curr.link.data;
		curr.link = null;
		size--;
		
		return popItem;
	}
	
	// 비어있는지 검사
	boolean isEmpty() {
		return size == 0;
	}
	
	
	void printAll() {
		Node curr = head.link;
		
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		} System.out.println();
	} 
	
}


public class LinkedStack {
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push("김정우");
		stack.push("김혜민");
		stack.push("양은서");
		stack.printAll();
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		stack.printAll();
		
	}
}
