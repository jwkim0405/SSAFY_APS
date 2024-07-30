package SWEA_1954_달팽이숫자;
import java.util.Scanner;

class Solution
{
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // test case 수 입력
        
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt(); 
            int[][] data = new int[n][n];
    
            int p = 0; int q = 0;   // p, q: 행, 열 위치
            
            // 달팽이 지나가기 시작
            for (int i = 1; i <= n * n; i++) {
                data[p][q] = i;
          
                if (q < n-1  && data[p][q+1] == 0) // 오른쪽이 비어있으면 오른쪽 먼저             
                	q++;
                
                else if (p < n-1 && data[p+1][q] == 0) // 아래쪽
                	p++; 
                   
                
                else if (q > 0 && data[p][q-1] == 0) // 왼쪽
                	q--; 
                
                else
                	p--; // 위쪽
           } 
            System.out.println("#" + (k+1)); 
            print(data);

        }
    }
	
	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}