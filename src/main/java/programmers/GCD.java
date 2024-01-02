package programmers;

public class GCD {
    public static void main(String[] args) {
        //최대공약수 192,162의 최대공약수는 6이다.
        System.out.println(gcd(192, 162));

    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a%b);
        }
    }
}
