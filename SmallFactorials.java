/*
    https://www.hackerearth.com/problem/algorithm/small-factorials/
    Small Factorials
    You are asked to calculate factorials of some small positive integers.

    Input
    An integer T, denoting the number of testcases, followed by T lines, each containing a single integer N.

    Output 
    For each integer N given at input, output a single line the value of N!

    Input Constraint

    1 <= T <= 100 
    1 <= N <= 100

    Sample Input
    4
    1
    2
    5
    3

    Sample Output
    1
    2
    120
    6
*/

/* IMPORTANT: class must not be public. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

class SmallFactorials {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            inputs.add(Integer.valueOf(br.readLine()));
        }
        ArrayList<BigInteger> outputs = new ArrayList<BigInteger>();
        for(Integer input : inputs){
            outputs.add(factorial(input));
        }
        for(BigInteger output : outputs) {
            System.out.println(output);
        }
    }

    public static BigInteger factorial(Integer input) {
        if (input == 1) return BigInteger.ONE;
        return(factorial(input-1).multiply(new BigInteger(String.valueOf(input))));
    }
}
