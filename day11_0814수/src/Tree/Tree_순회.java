package Tree;

public class Tree_순회 {
	
	static char[] tree = {0, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I'};
	
	public static void main(String[] args) {
		System.out.println("전위 순회");
		preorder(1);
		System.out.println();

		System.out.println("중위 순회");
		inorder(1);
		System.out.println();

		System.out.println("후위 순회");
		postorder(1);
		System.out.println();

	}
	
	// 매개변수로 트리의 루트 index 받기
	// 전위 순회 VLR
	public static void preorder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		System.out.print(tree[root] + "->");
		preorder(root * 2);   // 좌
		preorder(root*2 + 1); // 우
	}
	
	// 중위 순회 L->V->R
	public static void inorder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		inorder(root*2);
		System.out.print(tree[root] + "->");
		inorder(root*2+1);
	}
	
	// 후위 순회 L->R->V
	
	public static void postorder(int root) {
		if (root >= tree.length || tree[root] == 0)
			return;
		postorder(root * 2);
		postorder(root * 2 + 1);
		System.out.print(tree[root] + "->");
		
	}
}
