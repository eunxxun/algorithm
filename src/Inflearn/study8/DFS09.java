package Inflearn.study8;

import java.util.Scanner;

/**8-9 조합구하기
 4 2
 ->
 1 2
 1 3
 1 4
 2 3
 2 4
 3 4
 * */
public class DFS09 {
    static int[] combi;
    static int n,m;
    public void DFS(int L, int s){
        if(L == m){
            for(int c : combi) System.out.print(c +" ");
            System.out.println();
        }else{
            for(int i = s; i <= n; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        DFS09 T = new DFS09();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
        T.DFS(0, 1);

    }
}
