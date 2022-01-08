package Inflearn.study2;

import java.util.ArrayList;
import java.util.Scanner;

/** Array 01 큰 수 출력하기
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 */
public class Array01 {
    /*public String solution(int[] arr){
        String result = "";
        result += arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] < arr[i]){
                result += " ";
                result += arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(new Array01().solution(arr));
    }*/

    //전에 계쏙 문자열했더니.. 문자열에 넣을 생각만함..ㅋㅋ
    //ArrayList에 넣으면 더 간단..ㅎㅎ
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        Array01 T = new Array01();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, arr)){
            System.out.print(x+" ");
        }
    }
}
