package SWEA_햄버거다이어트;
import java.util.Scanner;

public class Solution {
    static int max = 0; // 맛점수 최고점
    static int[][] arr; // 맛 점수와 칼로리 점수 저장 배열
    int[] dp;  // 최대값 저장 배열
    static int N;
    static int L;
    static int sum_kcal = 0;
    static int sum_score = 0;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            max = 0;
            N = sc.nextInt(); // 개수
            L = sc.nextInt(); // 제한 칼로리
     
            // [i][0]: 맛 점수
            // [i][1]: 칼로리
             
            arr = new int[N][2];
             
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt(); // 맛
                arr[i][1] = sc.nextInt(); // 칼로리
            }
             
            find_max(0, 0, 0, true);
            find_max(0, 0, 0, false);
            System.out.println("#" + t + " " + max);
        }
         
    }
     
    static void find_max(int i, int kcal, int score,  boolean included) {
        if (i == N) {
            if (score > max && kcal <= L)
                max = score;
            return;
        }       
        if (!included) { // false(포함안하고 다음것 탐색)
            find_max(i+1, kcal, score, true);
            find_max(i+1, kcal, score,false);
            return;
        }
        else if (included &&(kcal + arr[i][1] > L)) { // 포함 && 칼로리가 제한 칼로리를 초과할때       
            return;
        }
        score += arr[i][0];
        kcal += arr[i][1];
 
        find_max(i+1, kcal, score, true);
        find_max(i+1, kcal, score, false);
    }
}