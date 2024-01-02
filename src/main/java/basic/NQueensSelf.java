package basic;

public class NQueensSelf {
    private static int N;
    private static int[] queens;
    private static int result;

    public static void solve(int n) {
        N = n;
        queens = new int[N];
        dfsQueen(0);
        System.out.println("Result : " + result);
    }

    private static void dfsQueen(int row) {
        //종료조건
        if (row == N) {
            result++;
            printSolution();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                dfsQueen(row+1);
                //back
            }
        }
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
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
        solve(4); // 4x4 체스판에 퀸을 배치
    }
}
