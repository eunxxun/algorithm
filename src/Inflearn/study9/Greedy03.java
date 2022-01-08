package Inflearn.study9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 9-3 결혼식
 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
 만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.

 입력) 첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
 두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
 시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.

 출력) 첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.
5
14 18
12 15
15 20
20 30
5 14
-> 2
 * */
class Friend implements Comparable<Friend>{
    public int time;
    public char type;

    Friend(int time, char type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Friend o) {
        if(this.time == o.time) return this.type - o.type;
        else return this.time - o.time;
    }
}

public class Greedy03 {
    public int solution(ArrayList<Friend> friends){
        int result = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(friends);
        for(Friend friend : friends){
            if(friend.type == 's') cnt++;
            else cnt--;

//            if(result < cnt) result = cnt;
            result = Math.max(result, cnt);
        }

        return result;
    }

    public static void main(String[] args) {
        Greedy03 T = new Greedy03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Friend> friends = new ArrayList<>();
        for(int i = 0; i < n; i++){
            friends.add(new Friend(sc.nextInt(), 's'));
            friends.add(new Friend(sc.nextInt(), 'e'));
        }
        System.out.println(T.solution(friends));
    }
}

