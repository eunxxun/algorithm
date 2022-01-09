package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1759 암호만들기(DFS 백트래킹)
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
 * 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
4 6
a t c i s w
 * <p>
 * 백트래킹은 알고리즘 기법 중 하나로, 재귀적으로 문제를 하나씩 풀어나가되 현재 재귀를 통해 확인 중인 상태(노드)가 제한 조건에 위배되는지(유망하지 않은지) 판단하고 그러한 경우 해당 상태(노드)를 제외하고 다음 단계로 나아가는 방식이다.
 * 여기서 알아둘 것은 특정 상태(노드)를 제외한다는 것이다.
 * 백트래킹은 현재 상태(노드)에서 다음 상태(노드)로 나아갈 수 있는 모든 경우를 찾되, 그 중 유망하지 않다면 현재에서 더 이상 나아가지 않고 이전의 상태(노드)로 돌아가 다음 상태(노드)를 검사한다.
 * 여기서 더 이상 탐색할 필요가 없는(유망하지 않은) 상태(노드)를 제외하는 것을 가지치기(pruning)라고도 한다.
 */
public class DFS_1759 {
    static int L, C;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);

        DFS(0, 0);
    }

    static void DFS(int start, int cnt) {
        if (cnt == L) {
            int v = 0; //모음
            int cc = 0; //자음
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < C; i++){
                if(visited[i]){
                    sb.append(arr[i]);

                    if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                        v++;
                    }else{
                        cc++;
                    }
                }
            }

            if(v >= 1 && cc >= 2) System.out.println(sb);
        } else {
            //백트래킹
            for(int i = start; i < C; i++){
                visited[i] = true;
                DFS(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
