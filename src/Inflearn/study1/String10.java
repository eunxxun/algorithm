package Inflearn.study1;

import java.util.Scanner;

/**
 * 인프런 01-10 가장 짧은 문자거리
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
teachermode e
 -> 1 0 1 2 1 0 1 2 2 1 0
fkdgkjdflkgjljslgjkfldjlkfdg f
 */
public class String10 {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == t) p = 0;
            else p++;
            answer[i] = p;
        }
        p = 1000;
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == t) p = 0;
            else p++;
            if(answer[i] > p) answer[i] = p;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char t = in.next().charAt(0);
        /*String str = "teachermode";
        String t = "e";*/
        for(int s : new String10().solution(str, t)) System.out.print(s+" ");
    }
}
