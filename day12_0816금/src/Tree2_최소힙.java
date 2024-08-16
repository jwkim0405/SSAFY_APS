
public class Tree2_최소힙 {
	static int[] heap = new int[100];
	static int heapSize = 0;
	
	public static void main(String[] args) {
		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);
		int size = heapSize;
		
		for (int i = 0; i < size; i++) {
			System.out.println(heapPop());
		}
	}
	
	
	static void swap(int p, int ch) {
		int tmp = heap[p];
		heap[p] = heap[ch];
		heap[ch] = tmp;
	}
	
	// 삽입 연산
	static void heapPush(int data) {
		// 완전 이진트리 마지막에 data 추가
		heap[++heapSize] = data;
		
		int p = heapSize / 2;
		int ch = heapSize;
		
		while (ch != 1 && heap[p] > heap[ch]) { // p와 ch를 swap!
			swap(p, ch);
			
			// 3. swap 이후의 인덱스 갱신
			ch = p;
			p = ch / 2;
		}
					
	}
	
	static int heapPop() {
		// 1. 루트에 있는 데이터 저장
		int popItem = heap[1];
		
		// 2. 마지막 노드를 루트로 옮긴다.
		heap[1] = heap[heapSize--];
		
		// 3. 자식과 부모 비교하여 swap
		int p = 1;
		int ch = p * 2;
		
		// 왼쪽 자식과 오른쪽 중 작은 자식 비교
		if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1])
			ch++;
		
		while(ch <= heapSize && heap[ch] < heap[p]) {
			swap(p, ch);
		
			// 4. swap 이후 index 갱신
			p = ch;
			ch = p * 2;
			// 왼쪽 자식과 오른쪽 중 작은 자식 비교
			if (ch + 1 <= heapSize && heap[ch] > heap[ch + 1])
				ch++;
			
		}
		
		return popItem;
	}
}
