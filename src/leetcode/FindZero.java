package leetcode;

// LeetCode 1304
// 주어진 정수가 홀수인지 짝수인지 판단하여 0을 포함 or 포함하지 않는 대칭 배열로 만든다.
public class FindZero {
    public int[] sumZero(int n) {
        int result[] = new int[n];
        int index = 0;

        if(n % 2 == 1) result[index++] = 0;

        n /= 2;

        for(int i = 1; i <= n; i++){
            result[index++] = i;
            result[index++] = -i;
        }

        return result;
    }

    public static void main(String[] args) {
        FindZero T = new FindZero();
        for(int a : T.sumZero(5)) System.out.print(a+" ");
        System.out.println();
        for(int a : T.sumZero(3)) System.out.print(a+" ");
        System.out.println();
        for(int a : T.sumZero(1)) System.out.print(a+" ");
    }
}
