import java.lang.*;
import java.io.*;

class FLIP
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase != 0){
            String A = br.readLine();
            String B = br.readLine();
            System.out.println(countFlips(A, B, A.length()-1));
            testCase--;
        }
    }

    public static int countFlips(String A, String B, int len){
        int i = 0;
        int count = 0;
        int flip = 0;
        while (i <= len){
            if(A.charAt(i) != B.charAt(i)){
                count++;
            } if(((A.charAt(i) == B.charAt(i)) ||
                    ((i + 1) == len) ||
                    (i == len))
                    && count > 0){
                flip++;
                count = 0;
            }

            i += 2;
        }
        i = 1;
        while (i <= len){
            if(A.charAt(i) != B.charAt(i)){
                count++;
            } if(((A.charAt(i) == B.charAt(i)) ||
                    ((i + 1) == len) ||
                    (i == len))
                    && count > 0){
                flip++;
                count = 0;
            }

            i += 2;
        }
        return flip;
    }
}