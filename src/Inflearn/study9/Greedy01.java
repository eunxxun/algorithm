package Inflearn.study9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**1. 씨름 선수
 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다. -> 이중포문 돌리면 timeout 발생함.
5
172 67
183 65
180 70
170 72
181 60
->3
(183, 65), (180, 70), (170, 72) 가 선발됩니다.
(181, 60)은 (183, 65)보다 키와 몸무게 모두 낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다.
 * */
public class Greedy01 {
    public int solution(ArrayList<Body> arr, int n){
        int cnt = 0;
        //키를 기준으로 내림차순 정렬하고 몸무게만 비교하면 O(n)으로 가능.
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Body body : arr){
            if(body.weight > max) {
                max = body.weight;
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Greedy01 T = new Greedy01();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int h=kb.nextInt();
            int w=kb.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.solution(arr, n));
    }
}

class Body implements Comparable<Body>{
    int height;
    int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
        return o.height - this.height; // Collections.sort하면 height순으로 내림차순된다.
    }
}
