import java.util.*;
import java.lang.*;
import java.io.*;

class SKMP
{
    public static void main (String[] args) throws Exception
    {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(br.readLine());
            for(int loop=0;loop<testCases;loop++){
                String str = br.readLine();
                long strLen = str.length();
                String ptrn = br.readLine();
                long ptrnLen = ptrn.length();
                StringBuilder build = new StringBuilder("");
                long[] arr = new long [27];
                long[] arr1 = new long [27];
                for(int i =0; i < strLen; i++)
                	arr[str.charAt(i)-'a']++;
                for(int i =0; i < ptrnLen; i++)
                	arr[ptrn.charAt(i)-'a']--;
                for(int i =0; i < 26; i++)
                	arr1[i] = arr[i];
                for(int i = 0; i <= (ptrn.charAt(0) - 'a'); i++)
                	while(arr[i] > 0){
                		build.append((char)(i+97));
                		arr[i]--;
                	}
                build.append(ptrn);
                for(int i =0; i < 26; i++)
                	while(arr[i] > 0){
                		build.append((char)(i+97));
                		arr[i]--;
                	}
                StringBuilder build2 = new StringBuilder("");
                for(int i=0; i< ptrn.charAt(0)-'a'; i++)
                	while(arr1[i]!=0){
                		build2.append((char)(i+97));
                		arr1[i]--;
                	}
                build2.append(ptrn);
                for(int i =0; i < 26; i++)
                	while(arr1[i] > 0){
                		build2.append((char)(i+97));
                		arr1[i]--;
                	}
                if(build.toString().compareTo(build2.toString()) < 0)
                	System.out.println(build);
                else System.out.println(build2);
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}
