package Inflearn.study10;

import java.util.Scanner;

/**1. 계단오르기
 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
7
 -> 21
 * */
public class Dynamic01 {
    //dynamic programming(동적계획법) -> 아주 작은 단위로 문제를 소형화 시킨다.(본질은 그대로 두고)
    //앞에 구한 답을 메모이제이션해서 확장해서 최종값을 구한다.
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i < n+1; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Dynamic01 T = new Dynamic01();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        dy=new int[n+1];
        System.out.print(T.solution(n));
    }
}
