package leetcode;

/**
 * 계단을 오르는데 드는 비용이 cost 정수 배열로 제공됩니다 . 비용을 지불하면 한 계단 또는 두 계단 올라갈 수 있습니다.
 * 0 index 가 있는 단계나 1 index 가 있는 단계 에서 시작할 수 있습니다.
 * 바닥의 꼭대기에 도달하기 위한 최소 비용을 반환합니다.
 * input : cost = [10,15,20]
 * output : 15
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * */
public class MinCostStairs {
    private static int minCostClimbingStairs(int[] cost) {
        int case1 = 0, case2 = 0, current;
        for (int i = cost.length - 1; i >= 0; --i) {
            current = cost[i] + Math.min(case1, case2);
            case2 = case1;
            case1 = current;
        }
        return Math.min(case1, case2);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1,2,3,4,5,6,7};
        int result = minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
