package SinglyLinkedList;

class  Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;
	// 기본 생성자
	SinglyLinkedList() {
		head = new Node();
	}
	
	// 삽입
	void addData(int i, String data) {
		// i 인덱스에 데이터 삽입
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if(!(0 <= i && i <= size)) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link; // 1번 반복하면 curr == A의 링크필드
		}
		
		// 새 노드부터 연결
		newNode.link = curr.link;
		
		// 그리고, 이전 노드에다가 newNode를 연결시켜줌
		curr.link = newNode;
		
		size++;
	}
	
	
	// 삭제
	void removeData(int i) {
		// 0번: 제일 앞에 있는 데이터 삭제
		// size - 1번: 마지막 데이터 삭제
		
		if (i < 0 || i >= size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		// 삭제할 노드의 앞 노드로 이동
		Node curr = head;
		
		// ex. head - (0) A - (1) B라고 하면, 1번 이동하여 curr ==> A
		for (int k = 0; k < i; k++) {
			curr = curr.link; 
		}
		
		curr.link = curr.link.link;
	}
	
	// 조회
	void printAll() {
		Node curr = head.link; // 처음 값이 있는 곳부터
		
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		} System.out.println();
	}
	
	
}


public class LinkedList_단순연결리스트_live {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "김정우");
		list.printAll();
		list.addData(0, "양은서");
		list.printAll();
		list.addData(0, "김혜민");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.printAll();
	}
}
