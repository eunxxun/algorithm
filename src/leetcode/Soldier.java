package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Soldier {
    public int solution(int[] ranks){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < ranks.length; i++){
            set.add(ranks[i]);
        }

        int cnt = 0;
        for(int x : ranks){
            if(set.contains(x+1)) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Soldier T = new Soldier();
        int[] ranks = {3,4,3,0,2,2,3,0,0};
        int[] ranks2 = {4,2,0};
        System.out.println(T.solution(ranks));
        System.out.println(T.solution(ranks2));
    }
}
