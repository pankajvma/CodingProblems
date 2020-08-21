import java.util.*;
import java.lang.*;
import java.io.*;

class CENS20G {
    public static StringBuilder YES;
    public static final String NO = new String("NO");
    public static final FastWriter out = new FastWriter();
    static class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    
    int nextInt() {
        return Integer.parseInt(next());
    }
    
    long nextLong() {
        return Long.parseLong(next());
    }
}

        static class FastWriter{
        BufferedWriter bw;
        FastWriter(){
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        void print(Object object) throws IOException{
            bw.append(""+object);
        }
        void println(Object object) throws IOException{
            print(object);
            bw.append("\n");
        }
        void close() throws IOException{
            bw.close();
        } 
    }
    
    public static void main(String[] args) throws Exception {
        try {
            FastScanner fs = new FastScanner();
            int testCases = fs.nextInt();
            for (int loop = 0; loop < testCases; loop++) {
                String str = fs.next();
                // System.out.println(str);
                char[] ch = str.toCharArray(); 
                int ax = fs.nextInt();
                int bx = fs.nextInt(); 
                int queries = fs.nextInt();
                int rCount = countChar(ch, 'R');
                int lCount = countChar(ch, 'L');
                int uCount = countChar(ch, 'U');
                int dCount = countChar(ch, 'D');
                for (int qLoop = 0; qLoop < queries; qLoop++) {
                    YES = new StringBuilder("YES ");
                    boolean possible1 = false, possible2 = false;
                    int x = fs.nextInt();
                    int y = fs.nextInt();
                    int a = ax, b = bx;
                    int count = 0;
                    if(x == a)
                        possible1 = true;
                    else if (x > a) {
                            if (rCount >= (x - a)) {
                                count = x-a;
                                possible1 = true;
                            }
                    } else if (x < a) {
                            if (lCount >= (a - x)) {
                                count = a - x;
                                possible1 = true;
                            }
                    }
                    if(y == b)
                        possible2 = true;
                    else if (y > b) {
                                if (uCount >= (y - b)) {
                                    count += y - b;
                                    possible2 = true;
                                }
                    } else if (y < b) {
                            if (dCount >= (b - y)) {
                                count += b - y;
                                possible2 = true;
                            }
                    }
                    String countString = Integer.toString(count);//String.valueOf(count);
                    YES.append(countString);
                    if(x == a && y == b)
                        out.println(YES);
                    else if(possible1 && possible2)
                        out.println(YES);
                    else out.println(NO);
                    }
                }
                out.close();
            }
        catch(Exception e){System.out.println(e);}
        }
        static int countChar(char[] ch, char stringChar){
            int charcount = 0;
            for(int i =0; i < ch.length; i++)
                if(ch[i] == stringChar)
                    charcount++;
            return charcount;
        }
    }
