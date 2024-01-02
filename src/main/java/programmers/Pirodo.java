package programmers;

public class Pirodo {
    private static boolean[] visited;
    private static int result;

    //{{80, 20}, {50, 40}, {30, 10}}
    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        result = Math.max(depth, result);
    }

    public int solution(int k, int[][] dungeons) {
       visited = new boolean[dungeons.length];
       result = 0;
       dfs(0,k,dungeons);
       return result;
    }

}
