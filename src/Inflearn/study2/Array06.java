package Inflearn.study2;

import java.util.ArrayList;
import java.util.Scanner;

/** Array 06 뒤집은 소수
 N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 첫 자리부터의 연속된 0은 무시한다.

 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 각 자연수의 크기는 100,000를 넘지 않는다.
 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 */
public class Array06 {
    private boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){ //2부터 자기자신 전까지 약수가 발견되면 false
            int tmp = arr[i];
            int reverse = 0;
            while(tmp > 0){
                int t = tmp % 10; // 1의자리
                reverse = reverse * 10 + t;
                tmp /= 10; //몫
            }
            if(isPrime(reverse)) result.add(reverse);
        }

        return result;
    }

    public static void main(String[] args){
        Array06 T = new Array06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
