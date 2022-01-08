package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-02 대소문자변환
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 * */
public class String02 {
    public String solution(String str){
        StringBuilder result = new StringBuilder();

        for(char c : str.toCharArray()){
            if(c < 97) result.append(Character.toLowerCase(c)); // if(Character.isLowerCase(c)) 써도됨.
            else result.append(Character.toUpperCase(c));


        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new String02().solution(str));
    }
}
