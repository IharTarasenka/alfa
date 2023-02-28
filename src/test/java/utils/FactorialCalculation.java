package utils;

import java.math.BigInteger;

public class FactorialCalculation {

//    TODO need to clarify how work with values=<0
    public static BigInteger factorialCalculation(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
