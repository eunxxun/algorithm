package Inflearn.study5;

import java.util.Scanner;
import java.util.Stack;

/***
 * Stack01 올바른괄호
 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
(()(()))(()
-> NO
 */
public class Stack01 {
    public String solution(String str) {
        String result = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";

        return result;
    }

    public static void main(String[] args){
        Stack01 T = new Stack01();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
