package Queue2_개인실습;

public class Queue2_우선순위큐 {
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		enQueue(5);
		enQueue(2);
		enQueue(3);
		enQueue(13);
		enQueue(7);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
	}
	
	static void enQueue(int data) {
		int i = ++rear;
		int j;
		for (j = i - 1; j >= 0 && queue[j] > data; j--) {
			queue[j+1] = queue[j]; // queue[j]가 queue[j+1] 자리로 감.
		} // 멈추는 경우: queue[j]보다 data가 큼. 
		// for문이 한 번이라도 수행되었다면, queue[j+1] 칸에서 원래의 값이 queue[j+2]로 이동한 상태.
		// 현재 queue[j+1] 칸이 비어있는 상태.
		// 한 번도 수행이 안 되었다면, j = i-1 => 정렬된 원소의 마지막 인덱스까지 그대로 있고, 자기 자신도 그대로 있으면 됨.
		queue[j+1] = data; // j = i -1 + 1 = i (==rear)
	}
	
	static int deQueue() {
		return queue[++front];
	}
	
}
