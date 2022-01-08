package Inflearn.study1;

import java.util.Scanner;

/** 인프런 01-04 단어 뒤집기
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 * */
public class String04 {
    public String solution(String str){
        /*StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();*/
        String tmp = new StringBuilder(str).reverse().toString();
        //StringBuilder를 쓰는 이유는?
        //스트링을 스트링끼리 더하거나 replace하면 계속 스트링 객체가 생성됨.
        //StringBuilder는 처음 만든 객체로 계속 쓰기 때문에 연산이 많을 땐 스트링 빌더를 사용함.
        return tmp;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = in.next();
        }

        for(String str : arr){
            System.out.println(new String04().solution(str));
        }
    }
}
