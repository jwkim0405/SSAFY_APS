package SWEA_보물상자비밀번호;
import java.util.*;

public class Solution {
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 16진수 총 자릿수
            int K = sc.nextInt(); // K번째로 큰 수
             
            String number = sc.next(); // 숫자 전체
             
            char[] charArr = number.toCharArray();
            Queue<Integer> queue = new LinkedList<>();
             
            // 각 자리 10진수 숫자로 구성된 큐 생성 
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] >= 'A' && charArr[i] <= 'F')
                    queue.offer(charArr[i] - 'A' + 10);
                else
                    queue.offer(charArr[i] - '0');
            }
             
            int item; // dequeue 임시 저장
            list = new ArrayList<>(); // 각각의 숫자 저장
             
            // 총 3개의 회전 경우의 수
            for (int rotation = 0; rotation < N / 4; rotation++) {
                // 총 4개의 변에 대해 수행
                for (int i = 0; i < 4; i++) {
                    int sum = 0;
                    for (int j = 0; j < N / 4; j++) { // 각 변에 대해 10진수 값 구하기
                        sum *= 16;
                        item = queue.poll();
                        sum += item;
                        queue.offer(item);
                    } 
                    if (!list.contains(sum)) // 중복되지 않는 숫자라면 추가
                        list.add(sum);
                }
                for(int i = 0; i < N-1; i++)
                    queue.offer(queue.poll());
            }
            list.sort(null);
            System.out.println("#" + t + " " + list.get(list.size() - K));
        }
    }
}