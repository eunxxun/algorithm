package Inflearn.study8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**8-5 동전교환
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
3
1 2 5
15
-> 3
 * */
public class DFS05 {
    static int n, m, result = Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr){
        if(sum > m) return;
        if(L >= result) return;
        if(sum == m) result = Math.min(sum, L);
        else{
            for(int i = 0; i < n; i++){
                DFS(L+1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        DFS05 T = new DFS05();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        //Collections 사용하려면 int[] -> Integer[] (객체형)으로 수정해줘야함.
        m = kb.nextInt();
        T.DFS(0,0, arr);
        System.out.println(result);
    }
}
