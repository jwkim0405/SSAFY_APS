package SWEA_1989_초심자의외문검사;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트 케이스 개수 입력

        for (int i = 1; i <= T; i++) {
            int res = check_palindrome(sc.next());  // 단어 입력받아 회문인지 검사
            System.out.println("#" + i + " " + res);
        }
    }

    static int check_palindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++)
            if (word.charAt(i) != word.charAt(n-1-i))
                return 0;
        return 1;
    }
}