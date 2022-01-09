package baekjoon;

import java.util.Scanner;

/**백준 1987
 * 세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
 * 말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
 *
2 4
CAAB
ADCB
 * */
public class DFS_1987 {
    static int R,C,answer = 0;
    static int[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        board = new int[R][C];
        for(int i = 0; i < R; i++){
            String s = sc.nextLine();
            for(int j = 0; j < C; j++){
                board[i][j] = s.charAt(j) - 'A';
            }
        }

        DFS(0,0,0);
        System.out.println(answer);
    }

    static void DFS(int x, int y, int count){
        if(visited[board[x][y]]){
            answer = Math.max(answer, count);
            return;
        }else{
            visited[board[x][y]] = true;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < R && ny < C){
                    DFS(nx,ny,count+1);
                }
            }
            visited[board[x][y]] = false;
        }
    }
}
