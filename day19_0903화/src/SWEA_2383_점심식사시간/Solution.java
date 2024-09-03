package SWEA_2383_점심식사시간;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    static int[][] map; // 초기 입력받는 배열
    static ArrayList<int[]> people; // 사람 있는 위치 좌표
    static ArrayList<int[]> stairs; // 두 개의 계단 좌표(i, j, 길이)
    static ArrayList<Integer> A; // 계단 1 그룹의 계단1까지의 거리
    static ArrayList<Integer> B; // 계단 1 그룹의 계단1까지의 거리
    static int people_cnt;
    static int result; // 최종 값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 지도 크기 설정
            map = new int[N][N]; // 지도 객체 생성
            people = new ArrayList<>(); // people 객체 생성
            stairs = new ArrayList<>();
            A = new ArrayList<>();
            B = new ArrayList<>();
            result = Integer.MAX_VALUE;

            people_cnt = 0;
            // 지도, 사람 위치, 계단 위치 및 크기 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();

                    // 값이 1이면, 좌표를 사람 배열에 넣자!
                    if (map[i][j] == 1) {
                        people.add(new int[]{i, j});
                        people_cnt++;
                    }
                    // 값이 1보다 크면, 계단!
                    else if (map[i][j] > 1) {
                        stairs.add(new int[]{i, j, map[i][j]});
                    }
                }
            }

            int A_dist = stairs.get(0)[2];
            int B_dist = stairs.get(1)[2];

            // 부분집합 2개로 나누기
            for (int i = 0; i < (1 << people_cnt); i++) {

                // 0 ~ N-1칸 비교하며 담기
                for (int j = 0; j < people_cnt; j++) {
                    int r = people.get(j)[0]; // 행
                    int c = people.get(j)[1]; // 열


                    // 0보다 크면 그룹 A
                    if ((i & (1 << j)) > 0) {
                        int dist = Math.abs(stairs.get(0)[0] - r) + Math.abs(stairs.get(0)[1] - c);
                        A.add(dist);
                    }
                    // 0이면 그룹 B
                    else {
                        int dist = Math.abs(stairs.get(1)[0] - r) + Math.abs(stairs.get(1)[1] - c);
                        B.add(dist);
                    }
                }
                // 거리 오름차순으로 정렬
                Collections.sort(A);
//				System.out.println(A);
                Collections.sort(B);


                // 이제 계단에서 내려보내자!
                // A 내려보내기
                int j = 3;

                while(j < A.size()) {
                    // end[0]과 start[A]부터 비교
                    // start[A]가 크거나 같다! 비어 있다! (가도 된다!)
                    if (A.get(j - 3) + A_dist <= A.get(j)) {
                        j++;
                    }
                    // 만약 더 작다!
                    else {
                        // 해당 인덱스부터 끝까지 값을 1 더해준다. (1분씩 더 기다려.)
                        int tmp = A.get(j);
                        A.set(j, tmp+1);
                    }
//						System.out.println(A);
                }


                // B 내려보내기
                j = 3;
                while(j < B.size()) {
                    // end[0]과 start[B]부터 비교
                    // start[B]가 크거나 같다! 비어 있다! (가도 된다!)
                    if (B.get(j - 3) + B_dist <= B.get(j)) {
                        j++;
                    }
                    // 만약 더 작다!
                    else {
                        // 해당 인덱스부터 끝까지 값을 1 더해준다. (1분씩 더 기다려.)
                        int tmp = B.get(j);
                        B.set(j, tmp+1);
                    }
                }
//				System.out.print(A);
//				System.out.println(" " + A_dist);
//				System.out.print(B);
//				System.out.println(" " + B_dist);

                // 최종 값 비교
                // A, B 중 더 큰 값이 최종값
                int max = 0;
                if (A.size() == 0)
                    max = B.get(B.size()-1) + B_dist;
                else if (B.size() == 0)
                    max = A.get(A.size()-1) + A_dist;
                else
                    max = Math.max(A.get(A.size()-1) + A_dist, B.get(B.size()-1) + B_dist);

                result = Math.min(max, result);
//				System.out.println(result+1);

                // 마지막 + 1

                // ArrayList 배열 초기화(다음 부분집합 담기 위함)
                A.clear();
                B.clear();
            } // for i

            // 결과 출력
            System.out.println("#" +  t + " " + (result+1));

        } // t
    } // main
} // class
