package Inflearn.study6;

import java.util.Scanner;

/**6-4 LRU(캐시, 카카오변형)
 *
 * */
public class Sort04 {
    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];
        for(int x : arr){
            int idx = -1;
            for(int i = 0; i < s; i++) if(cache[i] == x) idx = i; //겹치는 부분의 인덱스를 저장
            if(idx == -1){
                for(int i = s-1; i > 0; i--) cache[i] = cache[i-1];
            }else{
                for(int i = idx; i > 0; i--) cache[i] = cache[i-1];
            }
            cache[0] = x;
        }

        return cache;
    }
    public static void main(String[] args) {
        Sort04 T = new Sort04();
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        for(int x : T.solution(s, n, arr)) System.out.print(x+" ");
    }
}
