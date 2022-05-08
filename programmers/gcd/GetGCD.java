package programmers.gcd;

import java.math.BigInteger;

public class GetGCD {
    public static void main(String[] args) {
        int x = 100000000;
        int y = 100000000;

        // 초고수의 공략법 ㄷㄷ BigInteger에 gcd 함수가 있다.
        // long cout = x + y - BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).longValue();

        System.out.println(Euclidean(x, y));
    }

    public static int Euclidean(int x, int y)
    {
        int result = x % y;
        if(result == 0)
        {
            return y;
        }
        return Euclidean(y, result);
    }
}
