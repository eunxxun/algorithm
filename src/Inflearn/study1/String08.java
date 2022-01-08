package Inflearn.study1;

import java.util.Scanner;

/**
 * 인프런 01-08 유효한 팰린드롬
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * found7, time: study; Yduts; emit, 7Dnuof
 * -> YES
 */
public class String08 {
    //띄어쓰기, 특수문자는 제외해야함.
    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        String str = "found7, time: study; Yduts; emit, 7Dnuof";
        System.out.println(new String08().solution(str));
    }
}
