package basic;

// 조합의 경우의 수(메모이제이션)
// 5C3 -> 1,2,3,4,5 중에 3개의 수를 뽑아내는 경우의 수를 찾으면 된다.
public class Combination {
    /*int[][] dy = new int[35][35];//메모이제이션

    public int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); //dy[n][r]에 저장해서 리턴
    }*/

    static int[][] dy = new int[35][35];//메모이제이션

    static int DFS(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);

    }

    public static void main(String[] args) {
        Combination T = new Combination();
        int n = 5;
        int r = 3;
        System.out.println(T.DFS(n, r));
    }
}
