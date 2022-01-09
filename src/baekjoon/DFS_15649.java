package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 백준 15649 N과 M
 * 백트래킹 문제
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
4 2
 * */
public class DFS_15649 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    //출력을 매번 해줄 필요 없이 하나의 문자열로 묶어서 출력하는 방법이다. 기본적으로 입출력 자체가 자원을 많이 소모하기 때문에 반복적인 출력보다는 하나의 문자열로 연결해주는 것이 시간소모가 덜하다.
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int L){
        if(L == M){
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }else{
            for(int i = 0; i < N; i++){
                if(!visited[i]){
                    visited[i] = true;
                    arr[L] = i + 1;
                    DFS(L+1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 분리

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];
        DFS(0);
        System.out.println(sb);
    }
}
