package codility.dfs;

// programmers 코딩테스트 고득점 Kit DFS,BFS [단어변환]
public class ChangeWord {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        DFS(begin, target, words, 0);
        return answer;
    }

    public void DFS(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;

            int k = 0; //같은 알파벳 갯수
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }

            if(k == begin.length() - 1){ //한글자 빼고 모두 같은 경우
                visited[i] = true;
                DFS(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        ChangeWord T = new ChangeWord();
//        System.out.println(T.solution("hit",	"cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})); //4
        System.out.println(T.solution("hit",	"cog", new String[]{"hot", "dot", "dog", "lot", "log"})); //0
    }
}
