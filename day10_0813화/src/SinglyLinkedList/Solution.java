package SinglyLinkedList;

import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(0);
		list.add(10);
		list.add(1, 20);
		list.add(2, 30);
		System.out.println(list);
	}
}