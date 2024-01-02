package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BfsExample {
    private static boolean[] visited;
    private static int[][] graph;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int i = 0; i < graph[x].length; i++) {
                int y = graph[x][i];
                if (!visited[y]) {
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        visited = new boolean[9];
        graph = new int[][]{{}, {2, 3, 8}, {1,7},{1,4,5},{3,5},{3,4},{7},{2,6,8},{1,7}};
        bfs(1);
        //1 2 3 8 7 4 5 6
    }
}
