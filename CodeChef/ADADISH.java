import java.util.*;
import java.lang.*;
import java.io.*;

class ADADISH
{
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main (String[] args) throws Exception
    {
        System.setIn(new FileInputStream(new File("input.txt")));
        System.setOut(new PrintStream(new File("output.txt")));
        try{
            FastReader fs=new FastReader();
            int testCases=fs.nextInt();
            //System.out.println("1");
            for(int loop=0;loop<testCases;loop++){
                int noOfDishes = fs.nextInt();
                if(noOfDishes == 1){
                    System.out.println(fs.nextInt());
                    continue;
                }
                int[] arr = new int[noOfDishes];
                if(noOfDishes == 2){
                    arr[0] = fs.nextInt();
                    arr[1] = fs.nextInt();
                    System.out.println(Math.max(arr[0], arr[1]));
                    continue;
                }
                int len = noOfDishes - 1;
                for(int i=0; i <= len; i++)
                    arr[i] = fs.nextInt();
                Arrays.sort(arr);
                int time;
                int h1 = arr[len];
                int h2 = arr[len - 1];
                int current = len -2;
                while(current != -1){
                    if(h1 >= h2){
                        h2 += arr[current];
                    } else {
                        h1 += arr[current];
                    }
                    current--;
                }
                time = Math.max(h1, h2);
                System.out.println(time);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
