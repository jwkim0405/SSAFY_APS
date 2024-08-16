package Tree2_우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.age;
	}
	
	@Override
	// o: 상대방!!!
	// 오름차순
	public int compareTo(Person o) {
		// -1, 0, 1 셋 중 하나를 리턴
		// 0: 동일하다.
		// 1: 위치를 바꾼다
		// -1: 위치를 바꾸지 않는다.
		return this.age - o.age;
	}
}

public class Tree2_우선순위큐 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(-10);
		pq.add(40);
		
		while(!pq.isEmpty()) {
			int data = pq.poll();
			System.out.println(data);
		}
//		
		System.out.println();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq2.add(10);
		pq2.add(20);
		pq2.add(30);
		pq2.add(-10);
		pq2.add(40);
		
		while(!pq2.isEmpty()) {
			int data = pq2.poll();
			System.out.println(data);
		}
		
		System.out.println();
		
		PriorityQueue<Person> personPQ = new PriorityQueue<>();
		
		personPQ.add(new Person("루나", 3));
		personPQ.add(new Person("데이지", 1));
		personPQ.add(new Person("맥스", 8));
		
		while(!personPQ.isEmpty()) {
			Person data = personPQ.poll();
			System.out.println(data);
		}
		
		PriorityQueue<Person> personPQ2 = new PriorityQueue<>(new PersonComparator());
		
		personPQ2.add(new Person("루나", 3));
		personPQ2.add(new Person("데이지", 1));
		personPQ2.add(new Person("맥스", 8));
		
		System.out.println();
		
		while(!personPQ2.isEmpty()) {
			Person data = personPQ2.poll();
			System.out.println(data);
		}
	}
}
