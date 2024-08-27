package 스위치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 스위치의 개수
		int[] switches = new int[N+1]; // 스위치 on/off 여부
		
		// 스위치 on/off 정보
		for (int i = 1; i <= N; i++)
			switches[i] = sc.nextInt();
		
		// 학생 할당해주는 스위치 번호 개수
		int num = sc.nextInt();

		
		for (int i = 0; i < num; i++) {
			int gender = sc.nextInt(); // 성별
			int switch_num = sc.nextInt(); // 학생에게 나눠준 숫자
			// 남학생
			if (gender == 1) {
				for (int j = switch_num; j <= N; j += switch_num) { // 배수 (x1, x2...)
					if (switches[j] == 0) switches[j] = 1; // 0이면 1로!
					else if (switches[j] == 1) switches[j] = 0; // 1이면 0으로!
				}
			}
			
			// 여학생
			if (gender == 2) {
				// 자기 자신 0이면 1로, 1이면 0으로
				switches[switch_num] = switches[switch_num] == 1 ? 0 : 1; 
				
				int k = 1;
				int left;
				int right;
				while(true) {
					left = switch_num - k;
					right = switch_num + k;
					if(left >= 0 && right < N && switches[left] == switches[right]) {
						switches[left] = switches[left] == 1 ? 0 : 1;
						switches[right] = switches[left];
						k++;
					} else 
						break;
					
				}
			}
		}
		for (int i = 1; i <= N; i++)
			System.out.print(switches[i] + " ");
	}
}
