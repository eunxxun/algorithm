package basic;

public class NQueens {
    private static int N; // 체스판의 크기 (N x N)
    private static int[] board; // 각 행의 퀸이 위치한 열을 저장
    private static int solutions = 0; // 해결책의 수

    public static void solveNQueens(int n) {
        N = n;
        board = new int[N];
        placeQueen(0);
        System.out.println("Total solutions: " + solutions);
    }

    private static void placeQueen(int row) {
        if (row == N) {
            solutions++;
            printSolution();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) {
                board[row] = col;
                placeQueen(row + 1);
                // 백트래킹: 이전 상태로 되돌아감
            }
        }
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || // 같은 열 검사
                    Math.abs(row - i) == Math.abs(col - board[i])) { // 대각선 검사(두 칸이 대각선상에 위치하려면 그 칸들의 행과 열 간의 거리가 같아야 함)
                //row - i: 현재 검사하고 있는 퀸의 행(row)과 이전에 배치된 퀸의 행(i) 간의 차이
                //col - board[i]: 현재 검사하고 있는 퀸의 열(col)과 이전에 배치된 퀸이 있는 열(board[i]) 간의 차이
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        solveNQueens(4); // 4x4 체스판에 퀸을 배치
    }
}
