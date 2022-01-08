package Inflearn.study3;

import java.util.ArrayList;
import java.util.Scanner;

/** Two Pointer 01 두 배열 합치기
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
3
1 3 5
5
2 3 6 7 9
 -> 1 2 3 3 5 6 7 9
 * */
public class TwoPointer01 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> result = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m){ //while문은 참조건을 넣어줘야하니까 &&일때 둘 중 하나라도 만족을 못하면 while문은 끝나게 된다.
            if(a[p1] < b[p2]) result.add(a[p1++]); //p1++은 p1값을 add하고 그 다음에 p1을 하나 증가함.
            else result.add(b[p2++]);
        }

        //마지막에 남은게 p1인지 p2인지 모르기 떄문에 둘 다 while문이 거짓이 될 동안 넣어준다.
        while(p1 < n) result.add(a[p1++]);
        while(p2 < m) result.add(b[p2++]);

        return result;
    }

    public static void main(String[] args){
        TwoPointer01 T = new TwoPointer01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }
        for(int r : T.solution(n, m, a, b)) System.out.print(r + " ");
    }
}
