package codility.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 1. 좌우상하 이동할 때마다 큐에 저장
 * 2. 요구사항에 이동 불가능한 장소 및 이동했던 장소면 boolean 배열에 저잧
 * 3. 이동한 값들 저장된 큐가 다 빌때까지 반복
 * 4. x,y 좌표값이 해당 사각형 경로 이탈시 체크
 * 5. 최종지점 도착하는 이동값들 최소값 비교하여 반환
 *
 * Queue
 * add와 remove는 예외를 던지는 것으로 실패를 알리는 반면, offer와 poll은 특정 값을 반환하여 실패를 알립니다.
 * 이 차이는 큐의 용량이 제한되어 있거나 큐가 비어있을 가능성이 있는 상황에서 특히 중요합니다.-> offer, poll
 * */
public class GameMap2 {
    static final int[] rowArr = new int[]{1,-1,0,0};
    static final int[] colArr = new int[]{0,0,1,-1};

    static class Node {
        final int row;
        final int col;
        final int move;

        public Node(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
    public int solution(int[][] maps) {
        int rowLen = maps.length;//5
        int colLen = maps[0].length;//5
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(maps[i][j] == 0) visited[i][j] = true; // 못가는 길은 true
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            //동서남북
            for (int i = 0; i < 4; i++) {
                int row = n.row + rowArr[i];
                int col = n.col + colArr[i];
                if(rowLen <= row || row < 0 || colLen <= col || col < 0) continue;
                if(visited[row][col]) continue;

                visited[row][col] = true;
                queue.offer(new Node(row, col, n.move+1));
                if (row == rowLen-1 && col == colLen-1) {
                    min = Math.min(min, n.move+1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[][] map1 = new int[][]{{1,0,1,1,1},{1,0,1,0,1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] map2 = new int[][]{{1,0,1,1,1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        GameMap2 gameMap = new GameMap2();
        System.out.println(gameMap.solution(map1)); //11
        System.out.println(gameMap.solution(map2)); //-1
    }
}
