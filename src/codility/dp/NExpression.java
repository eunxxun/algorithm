package codility.dp;

/** N으로 표현
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 *
 * 동적 계획법은 DFS / BFS가 함께 쓰이는 프로그래밍중 하나이다.
 * 이 문제는 동적 프로그래밍 안에서 DFS(깊이 우선 탐색법)이 쓰이는 문제인데,
 * 8번의 깊이까지 탐색이 이루어지도록 재귀호출이 발생하는 프로그래밍이다.
 *
 * N 이라는 숫자를 이용해, 사칙연산의 경우의수를 조합하여 number를 만들어내야한다.
 * 근데 사칙연산만 존재하는것이 아니라, N의 수의 따라, NN (11, 22, 33.. 등과 같이 숫자 붙이기도 가능하다)
 * 핵심은 재귀함수를 들어갈때 사칙연산을 한 결과값을 가지고 들어가고 사칙연산을 하지 않고 숫자하나를 추가한 뒤 사칙연산에 들어가는 것이다.
 * */
public class NExpression {


    public int solution(int N, int number) {
        int answer = 0;



        return answer;
    }
    public static void main(String[] args) {
        NExpression T = new NExpression();
        System.out.println(T.solution(5,12));
        System.out.println(T.solution(2,11));
    }
}
