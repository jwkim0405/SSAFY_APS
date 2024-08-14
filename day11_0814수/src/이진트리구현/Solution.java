package 이진트리구현;

class Node {
	int data;
	Node left;
	Node right;
	
	Node (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	void addLeft(Node node) {
		this.left = node;
	}
	
	void addRight(Node node) {
		this.right = node;
	}
	
	void deleteLeft(Node node) {
		this.left = null;
	}
	
	void deleteRight(Node node) {
		this.right = null;
	}
}

class BinaryTree {
	BinaryTree() {
		
	}

	public Node addNode(int data) {
		Node node = new Node(data);
		return node;
	}
	
	public void preorder(Node root) {
		if (root == null)
			return;
		
		System.out.print(root.data + " -> ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " -> ");
		inorder(root.right);
	}
	
	public void postorder(Node root) {
		if (root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " -> ");
	}
}

public class Solution {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node1 = tree.addNode(1);
		Node node2 = tree.addNode(2);
		Node node3 = tree.addNode(3);
		Node node4 = tree.addNode(4);
		Node node5 = tree.addNode(5);
		Node node6 = tree.addNode(6);		
		Node node7 = tree.addNode(7);		
		
		node1.addLeft(node2);
		node1.addRight(node3);
		node2.addLeft(node4);
		node2.addRight(node5);
		node3.addLeft(node6);
		node3.addRight(node7);
		
		tree.preorder(node1);
		System.out.println();
		
		tree.inorder(node1);
		System.out.println();
		
		tree.postorder(node1);
		System.out.println();
	}
}