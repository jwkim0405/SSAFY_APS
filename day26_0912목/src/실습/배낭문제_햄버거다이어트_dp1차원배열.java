package 실습;

import java.util.Scanner;

public class Solution {

    static int N; // 재료 개수
    static int L; // 제한 칼로리
    static int[] scores;
    static int[] cals;
    static int[] dp; // 최대 점수 dp

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            L = sc.nextInt();
            scores = new int[N+1];
            cals = new int[N+1];
            dp = new int[L+1];
//            calDp = new int[N+1][L+1];

            for (int i = 1; i <= N; i++) {
                scores[i] = sc.nextInt(); // 맛 점수
                cals[i] = sc.nextInt(); // 칼로리
            }

            // ========== 입력 완료 ===========

            // i번까지의 재료를 사용해서 dp배열에 담을거야!
            for (int i = 1; i <= N; i++) {
                for (int j = L; j >= 1; j--) {
                    if (j >= cals[i]) {
                        dp[j] = Math.max(dp[j], dp[j-cals[i]] + scores[i]);
                    }
                }
            }
            System.out.println("#" + t + " " + dp[L]);
        } // for t
    } // main
} // class

