package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
2 -> 1
10 -> 3 (10 > 9 > 3 > 1)
*/
public class Dp_1463 {
//    static Integer[] dp;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        dp = new Integer[n + 1];
//        dp[0] = dp[1] = 0;
//        System.out.println(new Dp_1463().recur(n));
//    }
//
//    private int recur(int n){
//        //탐색하지 않았던 n일 경우
//        if(dp[n] == null){
//            //6으로 나눠질 경우
//            if(n % 6 == 0){
//                dp[n] = Math.min(recur(n - 1), Math.min(recur(n/3), recur(n/2))) +1;
//            }
//            //3으로만 나눠지는 경우
//            else if(n % 3 == 0){
//                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
//            }
//            //2로만 나눠지는 경우
//            else if(n % 2 == 0){
//                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
//            }
//            //2와 3으로 나눠지지 않는 경우
//            else {
//                dp[n] = recur(n - 1) + 1;
//            }
//        }
//        return dp[n];
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(recur(n,0));
    }

    static int recur(int n, int count){
        //n이 2 미만인 경우 누적된 count 값을 반환
        if(n < 2) return count;

        return Math.min(recur(n / 2, count + 1 + (n % 2)), recur(n / 3, count + 1 + (n % 3)));
    }
}
