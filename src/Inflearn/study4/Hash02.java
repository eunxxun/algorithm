package Inflearn.study4;

import java.util.HashMap;
import java.util.Scanner;

/***
 * Hash02 아나그램(해쉬)
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
AbaAeCe
baeeACA
 -> YES
abaCC
Caaab
 -> NO
 */
public class Hash02 {
    public String solution(String str1, String str2) {
        String result = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return "NO"; // value를 감소시키려고 get 했는데 이미 0이면 값이 다른거임.
            map.put(c, map.get(c)-1);
        }

        return result;
    }

    public static void main(String[] args){
        Hash02 T = new Hash02();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.nextLine();
        String str2 = kb.nextLine();
        System.out.println(T.solution(str1, str2));
    }
}
