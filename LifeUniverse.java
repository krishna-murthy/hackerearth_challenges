/*
    https://www.hackerearth.com/problem/algorithm/life-the-universe-and-everything/
    Life, the Universe, and Everything

    Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything. More precisely... rewrite small numbers from input to output. Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.

    Sample Input
     1
     2
     88
     42
     99

    Sample Output
      1
      2
      88
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class LifeUniverse {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            if (N == 42) {
                System.exit(0);
            }
            else {
                System.out.println(N);
            }
        }
    }
}
