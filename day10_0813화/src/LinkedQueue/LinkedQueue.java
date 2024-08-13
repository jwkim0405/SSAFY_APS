package LinkedQueue;

class Node {
	String data;
	Node link;
}


class Queue {
	Node head;
	int size;
	Queue() {
		head = new Node();
	}
	
	void enQueue(String data) {
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
	}
	
	String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		String item = head.link.data;
		head.link = head.link.link;
		size--;
		return item;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return head.link.data;
	}
	
	void printAll() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return;
		}
		Node curr = head.link;
		while(curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		} System.out.println();
	}
	
}

public class LinkedQueue {
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enQueue("김정우");
		queue.enQueue("유철희");
		queue.enQueue("김병지");
		queue.printAll();
		queue.deQueue();
		queue.printAll();
		System.out.println(queue.Qpeek());
	}
}
