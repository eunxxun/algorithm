package leetcode;

public class Clock {
    public int solution(String S, String T){
        int cnt = 0;
        int max = Integer.parseInt(T.replaceAll(":",""));
        int min = Integer.parseInt(S.replaceAll(":",""));
        return cnt;
    }

    public static void main(String[] args) {
        Clock T = new Clock();
        System.out.println(T.solution("15:15:00", "15:15:12"));
        System.out.println(T.solution("22:22:21", "22:22:23"));
    }
}
