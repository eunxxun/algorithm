package Inflearn.study7;

public class DFS01 {
    static int[] fibo;
    public int DFS(int n) {
        if(fibo[n] > 0) return fibo[n];
        if (n == 0) return fibo[n]=1;
        else if (n == 1) return fibo[n]=1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);

    }

    public static void main(String[] args) {
        DFS01 T = new DFS01();
        int n = 10;
        fibo = new int[n+1];
        T.DFS(n);
        for(int i = 1; i <=10; i++) System.out.print(fibo[i] +" ");
    }
}
