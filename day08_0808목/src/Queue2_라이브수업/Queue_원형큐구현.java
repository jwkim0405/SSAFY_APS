package Queue2_라이브수업;

import java.util.Arrays;

public class Queue_원형큐구현 {
	
	// 데이터를 담을 수 있다.
	static String[] queue = new String[4];
	static int front, rear;
	static int N = queue.length;
	
	public static void main(String[] args) {
		enQueue("루나");
		enQueue("데이지");
		enQueue("맥스");
		enQueue("김정우"); // 큐가 가득 찼습니다.
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		deQueue();
		deQueue();
		deQueue();
		deQueue(); // 큐가 비어있습니다.
		enQueue("김정우");
		enQueue("양은서");
		System.out.println(size());
		System.out.println(Arrays.toString(queue));

	}
	
	// 포화상태 확인
	static boolean isFull() {
		return (N + front - rear) % 4 == 1;
	}
	
	// 공백 상태 확인
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 삽입
	static void enQueue(String data) {
		if (isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		rear = (rear+1) % N;
		queue[rear] = data;
	}
	
	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		
		front = (front + 1) % N;
		String item = queue[front];
		queue[front] = null;
		return item;
	}
	
	// 조회
	static String Qpeek() {
		if (isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[(front+1)%N];	
	}
	
	static int size() {
		return (N + rear - front) % N;
	}
	
}
