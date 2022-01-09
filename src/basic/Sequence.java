package basic;

/** 수열 추측하기
 * 가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다.
 * 그리고 둘째 줄부터 차례대로 파스칼 의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
 * 예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
 * 3 1 2 4
 *  4 3 6
 *   7 9
 *   16
 * N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
 * 단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
 *
 풀이
 1. N이 4니까 3C0, 3C1, 3C2, 3C3를 미리 배열에 저장한다.(Combination)
 2. 무작위로 int[N] 배열에 저장한다.
 3. Combination값과 2번 배열의 값을 곱해서 sum에 더한다.
 4. sum이 f값이라면 리턴
*/
public class Sequence {
    static int[] combination, sequence, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : sequence) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    sequence[L] = i;
                    DFS(L + 1, sum + (sequence[L] * combination[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sequence T = new Sequence();
        n = 4;
        f = 16;
        combination = new int[n];
        sequence = new int[n];
        ch = new int[n + 1]; //check 배열 1부터 입력하도록
        for (int i = 0; i < n; i++) {
            combination[i] = T.combi(n - 1, i); //3C0, 3C1, 3C2, 3C3
        }
        T.DFS(0, 0);
    }
}
