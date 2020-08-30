import java.util.*;
import java.lang.*;
import java.io.*;

class MODEFREQ
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
        try{
            FastReader fs=new FastReader();
            int testCases=fs.nextInt();
            for(int loop = 0; loop < testCases; loop++){
                int numberOfAssignmentValues = fs.nextInt();
                int [] arrayOfAssignmentValues = new int[numberOfAssignmentValues];
                int [] frequencyArray = new int[10];
                int top = 0;
                int len = numberOfAssignmentValues - 1;
                for(int i = 0; i <= len; i++){
                    arrayOfAssignmentValues[i] = fs.nextInt();
                }
                int maxFrequency = 0, frequencyValue = 0, frequency = 0;
                boolean looper = true;
                for(int i = 0 ; i<= len; i++){
                    int temp = arrayOfAssignmentValues[i];
                    if(arrayOfAssignmentValues[i] == -1){
                        continue;
                    }
                    for(int j = 0; j <= len ; j++){
                        if(temp == arrayOfAssignmentValues[j]){
                            frequency++;
                            arrayOfAssignmentValues[j] = -1;
                        }
                    }
                    frequencyArray[top++] = frequency;
                    frequency = 0;
                }

                for(int i = 0 ; i< 10; i++){
                    int temp = frequencyArray[i];
                    if(frequencyArray[i] <= 0){
                        continue;
                    }
                    for(int j = 0; j < 10 ; j++){
                        if(temp == frequencyArray[j]){
                            frequency++;
                            frequencyArray[j] = -1;
                        }
                    }
                    if(frequency == maxFrequency && temp < frequencyValue){
                        frequencyValue = temp;
                    }
                    if(frequency > maxFrequency){
                        maxFrequency = frequency;
                        frequencyValue = temp;
                    }
                    frequency = 0;
                }
                System.out.println(frequencyValue);
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}
