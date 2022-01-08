package Inflearn.study5;

import java.util.Scanner;
import java.util.Stack;

/***
 * Stack04 후위식 연산(postfix)
 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다
352+*9-
-> 12
 */
public class Stack04 {
    public int solution(String str) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if(Character.isDigit(c)) stack.push(c-48); //char값에서 -48을 해야 숫자가 된다.
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+') stack.push(lt + rt);
                else if(c == '-') stack.push(lt - rt);
                else if(c == '*') stack.push(lt * rt);
                else if(c == '/') stack.push(lt / rt);
            }
        }
        result = stack.get(0);
        return result;
    }

    public static void main(String[] args){
        Stack04 T = new Stack04();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
