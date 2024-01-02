package programmers;

import java.util.LinkedList;
import java.util.Queue;

//구멍이 뚫려있는 부분이 0, 한번에 만들 수 있는 아이스크림의 갯수를 구해라.
public class IceCream {
    private static int[][] graph;
    private static int n, m;

    public static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        return 0;
    }

    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        //현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            //상하좌우 재귀호출
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        n = 4; m = 5;
        graph = new int[][]{
                {0,0,1,1,0}
                ,{0,0,0,1,1}
                ,{1,1,1,1,1}
                ,{0,0,0,0,0}
        };
        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
