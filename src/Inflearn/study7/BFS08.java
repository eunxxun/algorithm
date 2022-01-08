package Inflearn.study7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지찾기
public class BFS08 {
    /*int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1;
        Q.add(s);
        int level = 0;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i< len; i++){
                int x = Q.poll();
//                if(x == e) return level;
                for(int d : dis){
                    int nx = x + d;
                    if(nx == e) return level+1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0){ //==0은 아직 방문 안한거
                        ch[nx] = 1;
                        Q.add(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }*/

    int[] dis = {-1, 1, 5};
    int[] ch = new int[10001];
    int level = 0;
    public int BFS(int s, int e){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        ch[s] = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int cur = q.poll();
                if(cur == e) return level;
                for(int d : dis){
                    int nx = cur + d;
                    if(ch[nx] == 0 && nx >= 1 && nx <= 10000) {
                        q.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        BFS08 T = new BFS08();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
