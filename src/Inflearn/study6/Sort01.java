package Inflearn.study6;

import java.util.Scanner;

/***
 * Sort01 선택정렬
 6
 13 5 11 7 23 15
 -> 5 7 11 13 15 23
 */
public class Sort01 {
    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n-1; i++){ //마지막 자리는 무조건 크기 때문에 n-1까지 본다.
            int idx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Sort01 T = new Sort01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
