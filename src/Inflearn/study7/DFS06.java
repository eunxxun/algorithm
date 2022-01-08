package Inflearn.study7;

//부분집합 구하기(DFS)
public class DFS06 {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L == n+1){
            String tmp = "";
            for(int i = 1; i <= n; i++){
                if(ch[i] == 1) tmp += (i+" ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }else{
            ch[L] = 1;//사용한다.
            DFS(L+1);//왼
            ch[L] = 0;//사용안함
            DFS(L+1);//오
        }
    }
    public static void main(String[] args) {
        DFS06 T = new DFS06();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);
    }
}
