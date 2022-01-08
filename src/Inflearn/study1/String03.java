package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-03 문장 속 단어
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 * */
public class String03 {
    public String solution(String str){
        String answer="";
        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(' ')) != -1){
            String tmp=str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > m) answer = str;
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(new String03().solution(str));
    }
}
