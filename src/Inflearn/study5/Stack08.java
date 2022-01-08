package Inflearn.study5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 * Stack08 응급실
5 2
60 50 70 80 90
-> 3
6 3
70 60 90 60 60 60
 -> 4
 */
class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Stack08 {
    public int solution(int n, int m, int[] arr) {
        int result = 0;
        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.offer(new Person(i, arr[i]));
        }
        while(!queue.isEmpty()){
            Person tmp = queue.poll();
            for(Person x : queue){
                if(x.priority > tmp.priority){
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){ //위의 조건이 참이 아니였으면!
                result++;
                if(tmp.id == m) return result;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Stack08 T = new Stack08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
