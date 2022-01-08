package Inflearn.study5;

import java.util.Scanner;
import java.util.Stack;

/***
 * Stack03 크레인 인형뽑기(카카오)
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
 -> 4
 */
public class Stack03 {
    public int solution(int n, int m, int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> basket = new Stack<>();
        for(int move : moves){
            for (int i = 0; i < board.length; i++) {
                if(board[i][move-1] != 0) {
                    int tmp = board[i][move-1];
                    board[i][move-1] = 0;
                    if(!basket.isEmpty() && tmp == basket.peek()){
                        result += 2;
                        basket.pop();
                    }else basket.push(tmp);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Stack03 T = new Stack03();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, board, moves));
    }
}
