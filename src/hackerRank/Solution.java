package hackerRank;

import java.io.IOException;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
//        char first = s.charAt(0);
//        int delCount = 0;
//        for(int i = 1; i < s.length(); i++) {
//            char[] c = s.toCharArray();
//            if(c[i] == first) delCount++;
//            else first = c[i];
//        }
//        return delCount;
        // 헉 위에 내가한거는 타임아웃나는데 밑에는 안남;;;;
        int count = 0 ;
        String tmpS = "";
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.substring(i,i+1).equals(tmpS)) {
                count++;
            }else {
                tmpS = s.substring(i,i+1);
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        String s = "ABABABAAB";
        String s = "AAABBB";
        int result = Result.alternatingCharacters(s);
        System.out.println(result);
    }
}
