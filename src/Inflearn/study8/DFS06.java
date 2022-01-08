package Inflearn.study8;

import java.util.Scanner;

//8-6 순열구하기
public class DFS06 {
    static int n,m;
    static int[] ch, pm, arr;
    public void DFS(int L){
        if(L == m){
            for(int p : pm) System.out.print(p + " ");
            System.out.println();
        }
        else{
            for(int i = 0; i < n; i++){
                if(ch[i] == 0) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS06 T = new DFS06();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        ch=new int[n];
        pm=new int[m];
        T.DFS(0);
    }
}
