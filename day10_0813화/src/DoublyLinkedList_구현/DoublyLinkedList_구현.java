package DoublyLinkedList_구현;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int i, String data) {
		if (i < 0 || i > size) {
			System.out.println("인덱스의 범위를 벗어났습니다.");
			return;
		}
		size++;
		
		Node curr = head;
		Node newNode = new Node();
		newNode.data = data;
		
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		curr.next.prev = newNode;
		newNode.next = curr.next;
		
		curr.next = newNode;
		newNode.prev = head;
	}
	
	// 삭제
	void removeData(int i) {
		if (i < 0 || i > size - 1) {
			System.out.println("인덱스의 범위를 벗어났습니다.");
			return;
		}
		size--;
		
		Node curr = head.next;
		for (int k = 0; k < i; k++)
			curr = curr.next;
		
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
	}
	
	// 조회
	void reversePrint() {
		Node curr = tail.prev;
		
		String str = "";
		while(curr != head) {
			str = "<- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
	
	
	
}


public class DoublyLinkedList_구현 {
	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0,"김정우");
		list.addData(0,"김병지");
		list.addData(0,"유철희");
		list.reversePrint();
		
		list.removeData(0);
		list.reversePrint();
		
		
	}	
}
