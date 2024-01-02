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
 * */
public class GameMap {
    //rowArr = {1, -1, 0, 0}: 이 배열은 행(row)의 변화를 나타냅니다. 1은 아래로 한 칸 이동, -1은 위로 한 칸 이동을 의미합니다. 나머지 두 0은 행의 변화가 없음(즉, 좌우 이동)을 나타냅니다.
    //colArr = {0, 0, 1, -1}: 이 배열은 열(column)의 변화를 나타냅니다. 1은 오른쪽으로 한 칸 이동, -1은 왼쪽으로 한 칸 이동을 의미합니다. 나머지 두 0은 열의 변화가 없음(즉, 상하 이동)을 나타냅니다.
    static final int[] rowArr = new int[]{1,-1,0,0},
                        colArr = new int[]{0,0,1,-1};

    static class Node {
        final int row; //행
        final int col; //열
        final int move;

        public Node(int row, int col, int move) {
            this.row = row;
            this.col = col;
            this.move = move;
        }
    }
    public int solution(int[][] maps) {
        int rowLength = maps.length, colLength = maps[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(maps[i][j] == 0) visited[i][j] = true;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Node(0,0,1));
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = n.row + rowArr[i];
                int col = n.col + colArr[i];
                if(rowLength <= row || row < 0 || colLength <= col || col < 0) continue;
                if(visited[row][col]) continue;

                visited[row][col] = true;
                queue.offer(new Node(row, col, n.move+1));
                if(row == rowLength - 1 && col == colLength - 1)
                    min = Math.min(min, n.move+1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        //[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
        //[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
        int[][] map1 = new int[][]{{1,0,1,1,1},{1,0,1,0,1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] map2 = new int[][]{{1,0,1,1,1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        GameMap gameMap = new GameMap();
        System.out.println(gameMap.solution(map1)); //11
        System.out.println(gameMap.solution(map2)); //-1
    }
}
