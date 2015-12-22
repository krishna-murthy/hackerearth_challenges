/* 
    https://www.hackerearth.com/problem/algorithm/the-best-internet-browser-3/
    The best Internet Browser

In the race for the best Internet browser, there's now a new contender for it, this browser is called the: "The Semantic Mind-Reader!" After its promo on the world wide web, everyone's been desperately waiting for the browser to be released. And why shouldn't they be curious about it, after all, it's the new project of our very own genius "Little Jhool!" He's worked very hard for this browser, and to add new mind reading features to it.

Apart from the various security powers it possesses, it's called the mind-reader for a reason. Here's why:

You don't need to type 'www.' to open a website anymore.
Though, you still need to type '.com' to open a website.
The browser predicts ALL THE VOWELS in the name of the website. (Not '.com', though. Again!)
Obviously, this means you can type the name of a website faster and save some time.
Now to convince users that his browser will indeed save A LOT of time for users to open a particular website, Little Jhool has asked you to prepare a report on the same.

Input format:
    The first line contains tc, the number of test cases.
    The second line contains the name of websites, as a string.

Output format:
    You have to print the ratio of characters you would have typed in Jhool's browser, to your normal browser.

Constraints:
    1 <= tc <= 100
    1 <= Length of the website <= 200

NOTE: You do NOT need to print the output in its lowest format. You should print in its original fraction format.
The names of all the websites will be in small case only.

Every string will start from www. and end with .com, so well!

Sample Input
 2
 www.google.com
 www.hackerearth.com

Sample Output
  7/14
  11/19

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class InternetBrowser {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String websites[] = new String[N];
        String result[] = new String[N];
        for (int i = 0; i < N; i++) {
            String line1 = br.readLine();
            websites[i] = line1;
        }
        for (int i =0; i < N; i++) {
            String parts[] = new String[200];
            String website = websites[i];
            if ( website != null ) {
                parts = website.split("");
                int normalHit = website.length();
                int specialHit = 0;
                for(int j = 4; j < normalHit-3; j++) {
                    if ( parts[j].equals("a") || parts[j].equals("e") || parts[j].equals("i") || parts[j].equals("o") || parts[j].equals("u") ) {
                    }
                    else {
                        specialHit += 1;
                    }
                }
                specialHit += 3;
                result[i] = Integer.toString(specialHit) + '/' + Integer.toString(normalHit);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
