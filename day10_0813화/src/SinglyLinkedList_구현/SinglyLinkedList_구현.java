package SinglyLinkedList_구현;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;
	
	// 기본 생성자
	public SinglyLinkedList() {
		head = new Node();
	}
	
	// 삽입
	void addData(int i, String data) {		
		if (i < 0 || i > size) {
			System.out.println("인덱스 범위를 벗어났습니다.");
			return;
		}
		size++;
		
		Node newNode = new Node();
		newNode.data = data;
		
		Node curr = head;

		
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		// 새 노드부터 뒷 노드와 연결
		newNode.link = curr.link;
		
		// 앞 노드와 새 노드 연결
		curr.link = newNode;
	}
	// 삭제
	void removeData(int i) {
		if (i < 0 || i >= size) {
			System.out.println("인덱스 범위를 벗어났습니다.");
			return;
		}
		size--; // 노드 하나 지우기 때문에 사이즈 -1
		
		Node curr = head;
		
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
	}
	
	
	// 조회
	void printAll() {
		Node curr = head.link;
		
		while(curr != null) {
			System.out.print(curr.data + "-> ");
			curr = curr.link;
		} System.out.println();
	}


}

public class SinglyLinkedList_구현 {
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		
		list.addData(0, "김정우");
		list.addData(0, "조홍균");
		list.addData(0, "최보성");
		list.printAll();
		list.addData(1, "이윤준");
		list.printAll();
		list.removeData(0);
		list.printAll();

	}
}



