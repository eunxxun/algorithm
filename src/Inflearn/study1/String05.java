package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-05 특정 문자 뒤집기
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 * */
public class String05 {
    //내 풀이 : 영어문자열의 인덱스를 기억해뒀다가 역순으로 정렬한 영어문자열을 넣어주는 식.
    /*public String solution(String str){
        boolean[] eng = new boolean[str.length()];
        char[] strArr = str.toCharArray();
        int cnt = 0;
        StringBuilder reverseStr = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = strArr[i];
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                eng[i] = true;
                reverseStr.append(c);
            }else{
                eng[i] = false;
            }
        }
        reverseStr.reverse();

        for (int i = 0; i < eng.length; i++){
            if(eng[i]) {
                strArr[i] = reverseStr.charAt(cnt);
                cnt++;
            }
        }
        return String.valueOf(strArr);
    }*/

    //강의 풀이 : lt와 rt를 지정해서 문자열이면 swap하는 식으로 함.
    public String solution(String str){
        char[] c = str.toCharArray();
        int lt = 0, rt = c.length - 1;

        while(lt < rt){
            if(!Character.isAlphabetic(c[lt])) lt++;
            else if(!Character.isAlphabetic(c[rt])) rt--;
            else {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(c);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new String05().solution(str));
    }
}
