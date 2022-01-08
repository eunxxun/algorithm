package Inflearn.study8;

import java.util.Scanner;

/**8-10 미로탐색(DFS)
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
-> 8
 * */
public class DFS10 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;
    public void DFS(int x, int y){
        if(x == 7 && y == 7) answer++;
        else {
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
//                if(board[nx][ny] == 0 && nx >=1 && nx <= 7 && ny >= 1 && ny <= 7){ // 이렇게 하면 오류남;;
                if(nx >=1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS10 T = new DFS10();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 8; j++){
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1;
        T.DFS(1,1);
        System.out.println(answer);
    }
}
