package programmers;

import java.util.HashSet;

/** 소수찾기 ( 재귀 풀이 방법)
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 * 1,7,17,71
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 * 0,1,10,11,110,101
 * 11과 011은 같은 숫자로 취급합니다.
 * */
public class SearchPrime {
    private static HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 모든 조합의 숫자를 만든다. > recursive("", number)
        recursive("", numbers);

        // 2. 소수 판별
        //Iterator는 주로 컬렉션을 순회하면서 요소를 제거해야 할 때 또는 더 복잡한 반복 로직이 필요할 때 사용됩니다.
        //그러나 단순히 모든 요소를 순회하는 경우에는 향상된 for 루프나 forEach() 메소드가 더 간결하고 편리할 수 있습니다.
//        Iterator<Integer> it = numberSet.iterator();
        return (int)numberSet.stream()
                .filter(this::isPrime)
                .count();
    }

    public void recursive(String comb, String others) {
        // comb = 지금까지 조합한 숫자
        // others = 아직 조합하지 않은 숫자
        if (!comb.equals("")) {
            numberSet.add(Integer.valueOf(comb));
        }

        for (int i = 0; i < others.length(); i++) {
            System.out.println("i:"+i+" comb: "+comb+" others: "+others);
            recursive(comb + others.charAt(i), others.substring(0,i) + others.substring(i+1) );
        }
    }

    public boolean isPrime(int num) {
        //0과 1은 소수가 아니다.
        if (num == 0 || num == 1) {
            return false;
        }
        // num의 제곱근을 상한으로 설정
        int lim = (int) Math.sqrt(num);

        for (int i = 2; i <= lim; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime2(int num) {
        if(num == 0 || num == 1) {
            return false;
        }

        int lim = (int)Math.sqrt(num);
        for(int i = 0; i <= lim; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
