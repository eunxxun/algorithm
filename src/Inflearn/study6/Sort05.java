package Inflearn.study6;

import java.util.Arrays;
import java.util.Scanner;

/**6-5 중복확인
8
20 25 52 30 39 33 43 33
-> D
 * */
public class Sort05 {
    public String solution(int n, int[] arr){
        /*for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] == arr[j]) return "D";
            }
        }
        return "U";*/
        //정렬을 먼저 하면 이웃한 것들끼리만 비교해도 된다.
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 1; i < n; i++){
            if(arr[i-1] == arr[i]) {
                answer = "D";
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Sort05 T = new Sort05();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        System.out.println(T.solution(n, arr));
    }
}
