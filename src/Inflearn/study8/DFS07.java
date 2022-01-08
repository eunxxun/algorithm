package Inflearn.study8;

import java.util.Scanner;

/**8-7 조합의 경우수(메모이제이션)
 5 3
 -> 10
 33 19
 -> 818809200
 * */
public class DFS07 {
    int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(r == 0 || n == r) return 1;
        if(dy[n][r] > 0) return dy[n][r];
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        DFS07 T = new DFS07();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
