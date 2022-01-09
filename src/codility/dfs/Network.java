package codility.dfs;

/**
 * 네트워크
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 */
public class Network {
    static boolean[] ch;

    public void dfs(int[][] computers, int index) {
        ch[index] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[index][i] == 1 && index != i && !ch[i]) {
                dfs(computers, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        ch = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                answer++; //네트워크 증가
                dfs(computers, i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Network T = new Network();
        int[][] c1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] c2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(T.solution(3, c1)); // return 2
        System.out.println(T.solution(3, c2)); // return 1
    }
}
