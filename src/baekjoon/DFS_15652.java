package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 15651 N과 M(4)
 * 백트래킹 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
4 2
 * */
public class DFS_15652 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int at, int L){
        if(L == M){
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = at; i <= N; i++){
            arr[L] = i;
            DFS(i, L+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 분리

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        DFS(1,0);
        System.out.println(sb);
    }
}
