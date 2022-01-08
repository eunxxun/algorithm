package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-06 중복 문자 제거
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 * */
public class String06 {
    //내 풀이 : String의 contains를 사용함.
    public String solution(String str){
        char[] arr = str.toCharArray();
        String result = "";

        for(char c : arr) {
            if (!result.contains(String.valueOf(c))) result += c;
        }

        return result;
    }

    //강의 풀이 : indexOf를 사용함. indexOf는 제일 처음으로 발견한 문자의 인덱스번호를 리턴함.
    public String solution2(String str){
        String answer="";
        for(int i=0; i<str.length(); i++){
            //System.out.println(str.charAt(i)+" "+i+" "+str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new String06().solution(str));
        System.out.println(new String06().solution2(str));
    }
}
