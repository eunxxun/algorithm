package codility;

/**코딜리티 10-1
주어진 n의 약수들의 갯수를 출력하는 문제(N is an integer within the range [1..2,147,483,647] 1~21억?)

 일반적으로 약수를 구하는 보편적 코드는
 int n = 100;

 for(int i = 1; i <= n; i++){
    if(n % i == 0) 약수
 }

 => 그런데 이렇게 카운트를 세면 시간복잡도는 O(N), N이 int의 최대값(약 21억)으로 주어지면 시간초과
 => 만약 √(N)이 정수라면 √(N)은 N의 약수이며, 나머지 약수들은 √(N)를 기준으로 앞 뒤로 짝을 이루고 있다
 n = 24일때
 1,2,3,4,6,8,12,24
 => N의 범위가 21억까지니 long 자료형을 사용해야한다.
 */
public class CountFactors {
    public int solution(int N) {
        int count = 0;
        for(long i = 1; i*i <= N; i++){
            if(N % i == 0){
                count++;
                if(i*i < N) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountFactors T = new CountFactors();
        System.out.println(T.solution(24));
        System.out.println(T.solution(100));
    }
}
