package leetcode;

public class ReduceNum {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while(num > 0){
            if(num % 2 == 1){
                num -= 1;
                cnt++;
            }else{
                num /= 2;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ReduceNum T = new ReduceNum();
        System.out.println(T.numberOfSteps(14));
        System.out.println(T.numberOfSteps(123));
        System.out.println(T.numberOfSteps(8));
    }
}
