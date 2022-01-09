package codility.dfs;

/**
 * programmers 코딩테스트 고득점 Kit DFS,BFS [타겟넘버]
 */
public class TargetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0);
        return answer;
    }

    public void DFS(int[] numbers, int target, int depth){
        if (depth == numbers.length) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                sum += numbers[i];
            }
            if(sum == target) answer++;
            return;
        } else {
            numbers[depth] *= 1;
            DFS(numbers, target, depth+1);
            numbers[depth] *= -1;
            DFS(numbers, target, depth+1);
        }
    }

    public static void main(String[] args) {
        TargetNumber T = new TargetNumber();
        System.out.println(T.solution(new int[]{1,1,1,1,1}, 3));
    }
}
