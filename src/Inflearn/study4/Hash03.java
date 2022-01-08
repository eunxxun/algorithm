package Inflearn.study4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**4-3 매출액 구하기
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
7 4
20 12 20 10 23 17 10
 -> 3 4 4 3
 * */
public class Hash03 {
    public ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        int lt = 0;
        for(int i = 0; i < k-1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }

        for(int rt = k-1; rt < n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Hash03 T = new Hash03();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
    }
}
