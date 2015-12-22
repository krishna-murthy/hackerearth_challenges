/*
    https://www.hackerearth.com/problem/algorithm/complete-string-4/
    Complete String
    A string is said to be complete if it contains all the characters from a to z. Given a string, check if it complete or not.

    Input
    First line of the input contains the number of strings N. It is followed by N lines each contains a single string.

    Output
    For each test case print "YES" if the string is complete, else print "NO"

    Constraints
    1 <= N <= 10
    The length of the string is at max 100 and the string contains only the characters a to z

    Sample Input
     3
     wyyga
     qwertyuioplkjhgfdsazxcvbnm
     ejuxggfsts

    Sample Output
      NO
      YES
      NO
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class CompleteString {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String results[] = new String[N];
        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            List<String> alphabets = new ArrayList<String>(Arrays.asList(line1.split("")));
            if (alphabets.size() < 26) {
                results[i] = "NO";
            }
            else {
                Set<String> hs = new HashSet<String>();
                hs.addAll(alphabets);
                alphabets.clear();
                alphabets.addAll(hs);
                alphabets.removeAll(Arrays.asList(null,""));
                if (alphabets.size() == 26) {
                    results[i] = "YES";
                }
                else {
                    results[i] = "NO";
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(results[i]);
        }
    }
}
