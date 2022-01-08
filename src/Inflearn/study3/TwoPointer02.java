package Inflearn.study3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/** Two Pointer 02 공통 원소 구하기
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
5
1 3 9 5 2 -> 1 2 3 5 9
5
3 2 5 7 8 -> 2 3 5 7 8
 -> 2 3 5
 * */
public class TwoPointer02 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) p1++;
            else if(a[p1] > b[p2]) p2++;
            else result.add(a[p1++]);
        }

        return result;
    }

    public static void main(String[] args){
        TwoPointer02 T = new TwoPointer02();
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
