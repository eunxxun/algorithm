package Inflearn.study1;

import java.util.Scanner;

/**
 * 인프런 01-09 숫자만 추출
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
g0en2T0s8eSoft
-> 208
 */
public class String09 {
    public String solution(String str) {
        str  = str.replaceAll("[^0-9]", "");
        for(char c : str.toCharArray()){
            if(c == '0') str = str.substring(1);
            else break;
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        String str = "dkf0jkk0dkjkgjljl1kgh0ekjlkjf2lkjsklfjlkdj";
        System.out.println(new String09().solution(str));
    }
}
