/*
    https://www.hackerearth.com/problem/algorithm/roy-and-profile-picture/
    Roy and Profile Picture
    Roy wants to change his profile picture on Facebook. Now Facebook has some restriction over the dimension of picture that we can upload.
    Minimum dimension of the picture can be L x L, where L is the length of the side of square.

    Now Roy has N photos of various dimensions.
    Dimension of a photo is denoted as W x H 
    where W - width of the photo and H - Height of the photo

    When any photo is uploaded following events may occur:

    [1] If any of the width or height is less than L, user is prompted to upload another one. Print "UPLOAD ANOTHER" in this case.
    [2] If width and height, both are large enough and 
    (a) if the photo is already square then it is accepted. Print "ACCEPTED" in this case.
    (b) else user is prompted to crop it. Print "CROP IT" in this case.

    (quotes are only for clarification)

    Given L, N, W and H as input, print appropriate text as output.

    Input:
    First line contains L.
    Second line contains N, number of photos.
    Following N lines each contains two space separated integers W and H.

    Output:
    Print appropriate text for each photo in a new line.

    Constraints:
    1 <= L,W,H <= 10000
    1 <= N <= 1000

    Sample Input
     180
     3
     640 480
     120 300
     180 180

    Sample Output(Plaintext Link)
      CROP IT
      UPLOAD ANOTHER
      ACCEPTED
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

class RoyPicture {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int min = Integer.parseInt(line);
        String line1 = br.readLine();
        int N = Integer.parseInt(line1);
        String results[] = new String[N];
        for (int i = 0; i < N; i++) {
            String line2 = br.readLine();
            String parts[] = new String[2];
            parts = line2.split(" ");
            int height = Integer.parseInt(parts[0]);
            int width = Integer.parseInt(parts[1]);
            if ( height < min || width < min ) {
                results[i] = "UPLOAD ANOTHER";
            }
            else {
                if ( height == width) {
                    results[i] = "ACCEPTED";
                }
                else {
                    results[i] = "CROP IT";
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(results[i]);
        }
    }
}
