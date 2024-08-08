package Queue2_라이브수업;

import java.util.Arrays;

public class Queue_우선순위큐1차원배열 {
	
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		enQueue(10);
		enQueue(12);
		enQueue(3);
		enQueue(9);
		enQueue(8);
		
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
	}

	static void enQueue(int data) {
		int i = ++rear;
		int j;
		// 삽입 정렬
		// i: 정렬되지 않은 집합의 첫번째 원소
		for (j = i - 1; j >= 0 && queue[j] > data; j--) {
			queue[j+1] = queue[j];
		}
		queue[j+1] = data;
	}
	static int deQueue() {
		return queue[++front];
	}
}


