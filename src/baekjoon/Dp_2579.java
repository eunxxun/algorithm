package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*문제의 조건
1. 계단을 오를때 한계단이나 두계단 오를 수 있다.
2. 연속된 3개의 계단은 못 밟음
3. 마지막 계단은 반드시 밟아야한다.
*/
public class Dp_2579 {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        dp = new Integer[n + 1];
        arr = new int[n + 1];

        for(int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
        }

        dp[0] = arr[0]; //dp 디폴트 값이 null이라 0으로 초기화
        dp[1] = arr[1];

        if(n >= 2){
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(n));
    }

    static int find(int n){
        if(dp[n] == null){
            dp[n] = Math.max(find(n-2), find(n-3) + arr[n-1]) + arr[n];
        }
        Set a = new HashSet<Integer>();
        a.equals(1);
        return dp[n];
    }
}
