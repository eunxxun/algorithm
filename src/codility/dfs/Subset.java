package codility.dfs;

/**DFS
 * 부분집합 구하기
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력
 * n = 3
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 * */
public class Subset {
    static int n;
    static int[] ch;
    public void DFS(int L){
        //재귀함수는 종료조건 필수
        if(L == n+1){
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) System.out.print(i+" ");
            }
            System.out.println();
        }else{
            ch[L] = 1;
            DFS(L+1); //L을 포함한다.
            ch[L] = 0;
            DFS(L+1); //L을 포함하지 않는다.
        }
    }
    public static void main(String[] args) {
        Subset T = new Subset();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
