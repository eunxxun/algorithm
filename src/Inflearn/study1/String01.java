package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-01 문자찾기
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 * */
public class String01 {
    //non-static(instance method)
    public int solution(String str, char c){
        str = str.toLowerCase();
        c = Character.toLowerCase(c);
        int count = 0;
        for(char s : str.toCharArray()){
            if(s == c) count++;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        //static method에서 instance method 호출하려면 객체 생성을 해야하기 때문에 new로 객체 생성.
        System.out.println(new String01().solution(str, c));
    }
}
