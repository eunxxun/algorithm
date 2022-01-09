package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 백준 2583
 * M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
 * 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
 입력 예시
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

 풀이
 - 직사각형 좌표 준것의 영역을 1로 저장
 - 만약 배열 값이 0이라면 DFS를 돌고 0일떄마다 영역의 넓이를 구하는 count를 1씩 증가(증가시킨것의 영역은 1로 바꿔줌)
 - 배열을 완전탐색하면 ArrayList에는 넓이가 들어가는데 넓이의 개수를 구하면 직사각형의 갯수가 되고 ArrayList를 오름차순 정렬하여 출력한다.
 * */
public class DFS_2583 {
    static int M,N,K,count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];

        for(int i = 0; i < K; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int a = y1; a < y2; a++){
                for(int b = x1; b < x2; b++){
                    map[a][b] = 1;
                }
            }
        }

        ArrayList<Integer> areaList = new ArrayList<>();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) {
                    count = 0;
                    DFS(i, j);
                    areaList.add(count);
                }
            }
        }
        System.out.println(areaList.size());
        Collections.sort(areaList);
        for(Integer c : areaList) System.out.print(c + " ");
    }

    static public void DFS(int x, int y){
        map[x][y] = 1;
        count++;

        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N){ // 사각형 벗어나지 않도록 조건
                if(map[nx][ny] == 0) DFS(nx, ny);
            }
        }
    }
}
