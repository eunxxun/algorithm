package baekjoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10870
public class Fibonaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonaci(n));
    }
    public static int fibonaci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonaci(n-1) + fibonaci(n-2);
    }
}
