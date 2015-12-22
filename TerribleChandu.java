/*
    https://www.hackerearth.com/problem/algorithm/terrible-chandu/
    Terrible Chandu

    Chandu is a bad student. Once his teacher asked him to print the reverse of a given string. He took three hours to solve it. The teacher got agitated at Chandu and asked you the same question. Can you solve it?

    Input:
    The first line contains an integer T, denoting the number of test cases.
    Each test case contains a string S, comprising of only lower case letters.

    Output:
    For each test case, print the reverse of the string S.

    Constraints:
    1 <= T <= 10
    1 <= |S| <= 30

    Sample Input
    2
    ab
    aba
 
    Sample Output
    ba
    aba
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuffer;

class TerribleChandu {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            String reverse = new StringBuffer(line1).reverse().toString();
            System.out.println(reverse);
        }
    }
}
