package Queue1;

import java.util.Scanner;

public class Queue1_큐구현_라이브 {
	static String[] queue = new String[10];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 11; i++) {
			System.out.println("삽입할 문자열 입력: ");
			String item = sc.next();
			enQueue(item);
		}
		
		while(!isEmpty()) {
			String rItem = deQueue();
			System.out.println(rItem);
		}
		
	}
	
	// 공백 상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화 상태 확인
	static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	// 삽입
	// 삽입 성공 여부를 반환하려면 boolean 타입도 반환 가능
	static void enQueue(String item) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue[++rear] = item;
	}
	
	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}
	
	// 삭제할 원소 조회
	static String Qpek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front+1];
	}
	
	// 큐에 들어있는 데이터 개수
	static int size() {
		return rear - front;
	}
	
	
	
}
