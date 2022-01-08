package Inflearn.study6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 6-6 장난꾸러기
 */
public class Sort06 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        /*int[] answer = new int[2];
        int idx = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                answer[idx] = i;
                idx++;
            }
            if(idx == 2) break;
        }
        return answer;*/
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone(); // 깊은복사! = arr 만 해주면 얕은 복사임.
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) answer.add(i + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort06 T = new Sort06();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}
