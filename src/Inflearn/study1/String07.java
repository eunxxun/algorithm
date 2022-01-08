package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-07 회문 문자열
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 * */
public class String07 {
    //내 풀이 : 다시보니 거지같다..ㅎ
    public String solution(String str){
        str = str.toLowerCase();
        int lt = 0, rt = str.length() - 1;

        while(lt < rt) {
            if (str.charAt(lt) == str.charAt(rt)) {
                lt++;
                rt--;
            } else if(lt == rt){
                return "YES";
            } else {
                return "NO";
            }
        }
        return "YES";
    }

    //강의 풀이 : 홀수여도 len/2는 같다는 생각을 왜 못했뉘..
    public String solution2(String str){
        String answer="YES";
        str=str.toUpperCase();
        int len=str.length();
        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
        }
        return answer;
    }

    //강의 중 또 다른 풀이 : reverse를 사용해 주어진 스트링과 같은 지 비교!
    public String solution3(String str){
        String answer="NO";
        String tmp=new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer="YES";
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new String07().solution(str));
    }
}
