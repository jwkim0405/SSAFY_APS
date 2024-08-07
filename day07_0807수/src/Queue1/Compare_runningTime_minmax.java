package Queue1;

public class Compare_runningTime_minmax {
	public static void main(String[] args) {
		int N = 6;
		int M = 4;
		
		int startTime1 = (int) System.nanoTime();
		if (N > M) {
			int temp = N;
			N = M;
			M = temp;
		}
		int endTime1 = (int) System.nanoTime();
		int elapsedTime1 = endTime1 - startTime1;
		System.out.println("using swap: " + elapsedTime1);
		
		
		int A = 6;
		int B = 4;
		
		int startTime2 = (int) System.nanoTime();
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		int endTime2 = (int) System.nanoTime();
		int elapsedTime2 = endTime2 - startTime2;		
		System.out.println("using minmax: " + elapsedTime2);
	}
}
