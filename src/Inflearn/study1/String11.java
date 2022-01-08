package Inflearn.study1;

import java.util.Scanner;

/**
 * 인프런 01-11 문자열 압축
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
KKHSSSSSSSE
-> K2HS7E
 */
public class String11 {
    public String solution(String str) {
        String answer = "";
        str = str+" ";
        int cnt = 1;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String str = in.next();
        String str = "KKHSSSSSSSE";
        System.out.println(new String11().solution(str));
    }
}
