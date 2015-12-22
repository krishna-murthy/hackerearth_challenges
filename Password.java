/*
    https://www.hackerearth.com/problem/algorithm/password-1/
    Password
    Danny has a possible list of passwords of Manny's facebook account. All passwords length is odd. But Danny knows that Manny is a big fan of palindromes. So, his password and reverse of his password both should be in the list.

    You have to print the length of Manny's password and it's middle character.

    Note : The solution will be unique.

    INPUT 
    The first line of input contains the integer N, the number of possible passwords. 
    Each of the following N lines contains a single word, its length being an odd number greater than 2 and lesser than 14. All characters are lowercase letters of the English alphabet.

    OUTPUT 
    The first and only line of output must contain the length of the correct password and its central letter.

    CONSTRAINTS 
    1 ≤ N ≤ 100

    Sample Input
     4
     abc
     def
     feg
     cba

     Sample Output
      3 b
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Password {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String pwds[] = new String[N];
        for (int i = 0; i < N; i++) {
            pwds[i] = br.readLine();
        }
        boolean not_found = true;
        for (int j = 0; j < N; j++) {
            String reverse = new StringBuffer(pwds[j]).reverse().toString();
            if (not_found) {
                for (int k = 0; k < N; k++) {
                    if (pwds[k].equals(reverse) && j != k) {
                        not_found = false;
                        int res_length = (pwds[k].length())/2;
                        System.out.print(reverse.length() + " ");
                        String answer[] = new String[15];
                        answer = pwds[k].split("");
                        System.out.println(answer[res_length + 1]);
                    }
                }
            }
        }
    }
}
