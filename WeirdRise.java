/*
    https://www.hackerearth.com/problem/algorithm/the-rise-of-the-weird-things-1/
    The rise of the weird... things [1]

    Bangalore City, where peace prevails most of the time. Not everyone is a huge fan of peace, though. Certainly not Mr. XYZ, whose identity is not known to us - yet. Mr. XYZ has somehow managed to bring vampires and zombies to Bangalore City to attack and destroy the city.

    Fatal Eagle, an ordinary citizen of the city is extremely worried on seeing his city being attacked by these weird creatures. But, as of now, he has no power to stop these creatures from their silent attacks. He wants to analyze these creatures firstly. He figured out some things about these creatures, like:

    Zombies have power in terms of an EVEN number.
    Vampires have power in terms of an ODD number.
    If he sees a zombie or a vampire, he marks them in his list with their power. After generating the entire list of power of these creatures, he decides to arrange this data in the following manner:

    All the zombies arranged in sorted manner of their power, followed by the total power of zombies.
    All the vampires arranged in sorted manner of their power, followed by the total power of vampires.
    You've to help him produce the following list to help him save his city.

    Input constraints:
    The first line of input will contain an integer — N, denoting the number of creatures. The next line will contain N integers denoting the elements of the list containing the power of zombies and vampires.

    Output constraints:
    Print the required list in a single line.

    Constraints:
    1 ≤ N ≤ 103
    1 ≤ Ni ≤ 103

    Sample Input
     6
     2 3 10 12 15 22

    Sample Output
      2 10 12 22 46 3 15 18
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class WeirdRise {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        int odd_count = 0;
        int even_count = 0;
        String line1 = br.readLine();
        String inputs[] = new String[N];
        inputs = line1.split(" ");
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(inputs[i]);
            if (val % 2 == 0) {
                even_count += val;
                even.add(val);
            }
            else {
                odd_count += val;
                odd.add(val);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        for (Integer eve : even) {
            System.out.print(eve + " ");
        }
        System.out.print(even_count + " ");
        for (Integer od : odd) {
            System.out.print(od + " ");
        }
        System.out.println(odd_count);
    }
}
