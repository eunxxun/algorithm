package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchPrimeTest {
    @Test
    public void primeTest1() {
        SearchPrime sd = new SearchPrime();
        assertEquals(sd.solution("17"), 3);
//        assertEquals(sd.solution("011"), 2);
    }

    @Test
    public void sqrtTest() {
        int num = 64;
        int lim = (int) Math.sqrt(num); //제곱근 구하기
        System.out.println(lim);
    }

    @Test
    public void subStrTest() {
        String a = "123456";
        for (int i = 0; i < a.length(); i++) {
            System.out.println("(0,i)" + a.substring(0,i));
            System.out.println("i+1:" + a.substring(i+1)); //beginIndex
        }
    }

}