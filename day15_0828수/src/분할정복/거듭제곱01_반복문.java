package 분할정복;

public class 거듭제곱01_반복문 {

	public static void main(String[] args) {
		int C = 2;
		int N = 10;
		
		System.out.println(pow(2, N));
		System.out.println(pow2(2, N));
		
	}

	public static int pow(int C, int N) {
		int result = 1;
		for (int i = 1; i <= N; i++) {
			result *= C;
		}
		return result;
	}
	
	public static int pow2(int C, int N) {
		if (N == 0)
			return 1;
		return C * pow(2, N-1);
	}
 }
