package Inflearn.study2;

import java.util.Scanner;

/** Array 04 피보나치 수열
 * 1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 */
public class Array04 {
    public int[] solution(int n){
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i < n; i++){
            result[i] = result[i - 2] + result[i - 1];
        }

        return result;
    }

    public static void main(String[] args){
        Array04 T = new Array04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int x : T.solution(n)){
            System.out.print(x + " ");
        }
    }
}
