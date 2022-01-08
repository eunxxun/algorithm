package codility;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        /*Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c != '}' && c != ']' && c != ')') stack.push(c);
            else if(stack.contains('{') && c == '}') stack.pop();
            else if(stack.contains('[') && c == ']') stack.pop();
            else if(stack.contains('(') && c == ')') stack.pop();
            else if(stack.isEmpty()) return 0;
        }
        if(stack.isEmpty()) return 1;
        else return 0;*/
        //원래 내가 푼거는 범위가 커지면 에러가 난다...ㅎㅎ

        Stack<Character> stack = new Stack<>();
        char lastChar;
        for (char c : S.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.empty()) return 0;
                lastChar = stack.pop();

                if (c == ')' && lastChar != '(') return 0;
                else if (c == ']' && lastChar != '[') return 0;
                else if (c == '}' && lastChar != '{') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Brackets T = new Brackets();
        String s1 = "{[()()]}";
        String s2 = "([)()]";
        System.out.println(T.solution(s1));
        System.out.println(T.solution(s2));
    }
}
