package Inflearn.study7;

//그래프 최단거리

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
 * 1 <- 2 -> 5
 * |  \  /\  |
 * 3 -> 4 -> 6
 *
 ▣ 입력예제 1
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 ▣ 출력예제 1
 2:3
 3:1
 4:1
 5:2
 6:2
 * */
public class BFS14 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);
        while(!q.isEmpty()){
            int current = q.poll();
            for(int nv : graph.get(current)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[current] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        BFS14 T = new BFS14();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
