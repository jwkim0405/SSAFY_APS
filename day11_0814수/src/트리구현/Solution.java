package 트리구현;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node {
	Map<Integer, Node> map = new HashMap<>(); 
	LinkedList<Node> link = new LinkedList<>();
}

class Tree {
	int index = 1;
	Node root;
	
	Tree() {
		root = new Node();
	}
	
	void addData(int pNode, int data) {
		if (root == null) {
			root.index = index++;
			root.data = data;
		} else {
			
		}
	}
	
}

public class Solution {
	public static void main(String[] args) {
		
	}
}