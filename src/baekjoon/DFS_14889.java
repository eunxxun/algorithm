package baekjoon;

import java.util.Scanner;

/** 백준 14889 스타트와 링크(DFS,조합)
4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0
 * */
public class DFS_14889 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    //조합을 하기 위해 반복문과 반복문 안에 재귀호출을 한다.
    static void combi(int idx, int count){
        //팀 조합이 완성될 경우
        if(count == N/2){
            //방문한 팀과 방문하지 않은 팀을 각각 나눠 각 팀의 점수를 구한 뒤 최소값을 찾는다.
            diff();
            return;
        }

        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    //두 팀의 능력치 차이 계산
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                //i번째 사람과 j번째 사람이 true라면 스타트팀으로 점수 플러스
                if(visited[i] && visited[j]){
                    team_start += map[i][j];
                    team_start += map[j][i];
                }

                //i번째 사람과 j번째 사람이 false라면 링크팀으로 점수 플러스
                if(!visited[i] && !visited[j]){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        //점수차(절대값)
        int val = Math.abs(team_start - team_link);

        //두팀의 점수차가 0이면 이미 최소값이니 종료해버림
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        combi(0,0);
        System.out.println(min);
    }
}
