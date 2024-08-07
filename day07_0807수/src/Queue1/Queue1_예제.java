package Queue1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	int no;
	String name;
	int candy;
	
	// 생성자
	public Person(int no, String name, int candy) {
		super();
		this.no = no;
		this.name = name;
		this.candy = candy;
	}
	
}

public class Queue1_예제 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Person> queue = new LinkedList<>();
		
		// 전체 사탕 개수
		int N = 20;
		
		int pNum = 1;
		
		String name = sc.next();
		System.out.println(name + "님이 새로 줄을 섭니다.");
		queue.add(new Person(pNum++, name, 1));
		while(N > 0) {
			// 큐에서 한 명이 빠져나와서 마이쮸를 가져간다.
			Person p = queue.poll();
			N -= p.candy;
			
			System.out.println(p.no +"번 " + p.name +   "님이 마이쮸를 " + +p.candy +  "개 가져갔습니다");
			
			if (N <= 0) {
				System.out.println(p.name + "님이 마지막 마이쮸를 가져갔습니다.");
				break;
			}
			
			p.candy++;
			// 가져갈 수 있는 개수를 늘리고 삽입
			queue.add(p);
			
			// 새 멤버 추가
			System.out.print("새 멤버: ");
			String newMember = sc.next();
			queue.add(new Person(pNum++, newMember, 1));
		}

	}
}
