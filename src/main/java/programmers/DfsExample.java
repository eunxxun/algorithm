package programmers;

public class DfsExample {
    private static boolean[] visited;
    private static int[][] graph;

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int i = 0; i < graph[x].length; i++) {
            int y = graph[x][i];
            if (!visited[y]) {
                dfs(y);
            }
        }
    }
    public static void main(String[] args) {
        visited = new boolean[9];
        graph = new int[][]{{}, {2, 3, 8}, {1,7},{1,4,5},{3,5},{3,4},{7},{2,6,8},{1,7}};
        dfs(1);
        //1 2 7 6 8 3 4 5
    }
}
