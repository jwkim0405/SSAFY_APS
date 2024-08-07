package Queue1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue1_큐API {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입
		// add: 원소를 추가할 수 없는 상황이 오면 예외 발생
		// offer: 추가할 수 없는 상황이 오면 false 반환
		queue.add(1); 
		queue.offer(1);
		System.out.println(queue);
		// 삭제
		queue.remove(); // 삭제될 수 없으면 예외 발생
//		queue.poll();	// 삭제될 수 없으면 return null;
		
		System.out.println(queue);
		
		// 조회
//		queue.element(); // 예외 발생
		System.out.println(queue.peek());    // return null;
		
	}
}
