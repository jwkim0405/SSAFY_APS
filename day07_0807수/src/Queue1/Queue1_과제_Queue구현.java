package Queue1;

import java.util.LinkedList;
import java.util.List;

public class Queue1_과제_Queue구현 {
	public static void main(String[] args) {
		// Integer형으로 사용해보기
		Queue<Integer> queue1 = new Queue<>();
	
		System.out.println(queue1.isEmpty());
		queue1.enQueue(3);
		queue1.enQueue(5);
		System.out.println(queue1.deQueue());
		System.out.println(queue1.Qpeek());
		System.out.println(queue1.deQueue());
		System.out.println(queue1.deQueue());
		
		System.out.println();
		
		// Character형으로 사용해보기
		Queue<Character> queue2 = new Queue<>();
		
		System.out.println(queue2.isEmpty());
		queue2.enQueue('a');
		queue2.enQueue('b');
		System.out.println(queue2.deQueue());
		System.out.println(queue2.Qpeek());
		System.out.println(queue2.deQueue());
		System.out.println(queue2.deQueue());
		
		System.out.println();

		// Character형으로 사용해보기
		Queue<String> queue3 = new Queue<>();
		
		System.out.println(queue3.isEmpty());
		queue3.enQueue("Jeongwoo");
		queue3.enQueue("윤준!");
		System.out.println(queue3.deQueue());
		System.out.println(queue3.Qpeek());		
		System.out.println(queue3.deQueue());
		System.out.println(queue3.deQueue());
		
	}
	
	public static class Queue<E> {
		// LinkedList
		List<E> queue = new LinkedList<>();
		int front = -1;
		int rear = -1;

		public Queue() {}
		
		// enQueue
		void enQueue(E c) {
			rear++;
			queue.add(c);
		}
		
		// deQueue
		E deQueue() {
			if (isEmpty()) {
				System.out.println("리스트가 비어있습니다.");
				return null;
			}
				
			return queue.get(++front);
		}
		
		// Qpeek
		E Qpeek() {
			return queue.get(front + 1);
		}
		
		// isEmpty
		boolean isEmpty() {
			if (rear == front)
				return true;
			return false;
		}

		// size
		int size() {
			return rear - front;
		}
		
	}
}


