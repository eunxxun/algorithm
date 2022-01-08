package Inflearn.study8;

import java.util.Scanner;

/**
 * 8-4 중복순열 구하기
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다.
 * ▣ 입력예제
 * 3 2
 * ▣ 출력예제
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
public class DFS04 {
    static int n, m;
    static int[] pm;

    public int DFS(int L) {
        if (L == m){
            System.out.print(pm[0] + " " + pm[1]);
            System.out.println();
        }else{
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DFS04 T = new DFS04();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
