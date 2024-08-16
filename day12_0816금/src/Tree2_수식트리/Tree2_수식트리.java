package Tree2_수식트리;

public class Tree2_수식트리 {
	static char[] tree = {0, '+', 'x', '-', '1', '2', '3', '4'};
	
	public static void main(String[] args) {
		
		
	}
	
	// 중위순회
	static void inorder(int root) {
//		// 기저조건1: 인덱스가 배열 범위를 벗어남
//		if (root >= tree.length)
//			return;
//		
//		// 기저조건2: leaf node인 경우, leaf node는 항상 피연산자
//		if (tree[root] >= '0' && tree[root] <= '9') {
//			System.out.print(tree[root]);
//			return;
//		}
		
		// 재귀 영역
		if (root * 2 < tree.length)
			inorder(root * 2);
		System.out.print(tree[root] + " ");
		if (root * 2 + 1< tree.length)
			inorder(root * 2 + 1);
	}
	
	static void postorder(int root) {
		
	}
}
