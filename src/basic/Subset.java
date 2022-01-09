package basic;

/**DFS
 * 부분집합 구하기
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력
 * */
public class Subset {
    static int n;
    static boolean[] ch;

    static void DFS(int level){
        if(level == n+1){
            for(int i = 1; i <= n; i++){
                if(ch[i]) System.out.print(i + " ");
            }
            System.out.println();
        }else{
            ch[level] = true;
            DFS(level+1);
            ch[level] = false;
            DFS(level+1);
        }
    }

    public static void main(String[] args) {
        Subset T = new Subset();
        n = 3;
        ch = new boolean[n+1];
        T.DFS(1);
    }
}
