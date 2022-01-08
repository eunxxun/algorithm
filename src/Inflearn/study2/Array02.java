package Inflearn.study2;

import java.util.Scanner;

/** Array 02 보이는 학생
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
 * ex ) 8    130 135 148 140 145 150 150 153 -> 5 출력
 */
public class Array02 {
    public int solution(int[] arr){
        int max = arr[0];
        int cnt = 1;

        for(int a : arr){
            if(max < a){
                cnt++;
                max = a;
            }
        }

        return cnt;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(new Array02().solution(arr));
    }
}
