package programmers;

public class TargetNumber {
    private static int count;
    private static int goal;
    private static int[] arr;

    public int solution(int[] numbers, int target) {
        count = 0;
        goal = target;
        arr = numbers;
        dfs(0, 0);
        return count;
    }

    private void dfs(int depth, int result) {
        if (depth == arr.length) {
            if (goal == result) {
                count++;
            }
            return;
        }

        dfs(depth+1, result + arr[depth]);
        dfs(depth+1, result - arr[depth]);
    }

    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(new int[]{1,1,1,1,1}, 3));
//        System.out.println(tn.solution(new int[]{4,1,2,1}, 4));
//        System.out.println(tn.solution(new int[]{4,1,2,1}, 100));
    }
}
