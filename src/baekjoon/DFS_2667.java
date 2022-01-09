package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**백준 2667 단지번호붙이기
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 * */
public class DFS_2667 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] houses;
    static int N, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        houses = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = sc.next();
            for(int j = 0; j < N; j++){
                houses[i][j] = line.charAt(j) - 48;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(houses[i][j] == 1){
                    count = 0;
                    DFS(i,j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int cnt : list){
            System.out.println(cnt);
        }
    }

    public static void DFS(int x, int y){
        houses[x][y] = 0;
        count++;

        for(int i = 0;i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N  && ny < N){
                if(houses[nx][ny] ==1) DFS(nx, ny);
            }
        }
    }
}
