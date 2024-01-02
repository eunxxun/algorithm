package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//이거 지우고 다시 풀어보기. (https://m.blog.naver.com/sosow0212/222961687890)
public class TravelPath {
    private static boolean[] visited;
    private static List<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs(0,"ICN","ICN", tickets);
        Collections.sort(result);

        return result.get(0).split(" ");
    }

    //{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
    public void dfs(int idx, String start, String route, String[][] tickets) {
        //종료조건
        if (idx == tickets.length) {
            result.add(route);
            return;
        }

        //백트래킹
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(idx+1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }

    }
}
