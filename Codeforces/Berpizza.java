import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.io.*;
import java.util.*;

public class Berpizza {
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[128]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class Customers{
        int id;
        int money;

        public Customers(int id, int money) {
            this.id = id;
            this.money = money;
        }
    }

    static int top = -1;
    static int idBase = 0;
    static int moneyBase = 0;
    static ArrayList<Customers> orderById = new ArrayList<>();
    static ArrayList<Customers> orderByMoney = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
            FastReader fs = new FastReader();
            int q = fs.nextInt();
            int id = 0;
            while (q != 0) {
                int check = fs.nextInt();
                if(check == 1){
                    int money = fs.nextInt();
                    id++;
                    top++;
                    Customers newCustomer = new Customers(id, money);
                    orderById.add(newCustomer);
                    addToOrderByMoney(newCustomer);
                }else if(check == 2){
                    for(int i = idBase; i <= top; i++){
                        if(orderById.get(i).id != 0){
                            System.out.println(orderById.get(i).id);
                            orderById.get(i).id = 0;
                            break;
                        }
                        idBase++;
                    }
                } else{
                    for(int i = moneyBase; i <= top; i++){
                        if(orderByMoney.get(i).id != 0){
                            System.out.println(orderByMoney.get(i).id);
                            orderByMoney.get(i).id = 0;
                            break;
                        }
                    }
                    moneyBase++;
                }
                q--;
            }

            System.out.println("check money:");
            for(Customers i : orderByMoney){
                System.out.println(i.id + " " + i.money);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addToOrderByMoney(Customers newCustomer){
        int temp = top;
        if( temp == 0 || orderByMoney.get(temp - 1).money >= newCustomer.money){
            orderByMoney.add(newCustomer);
        }else{
            while(temp > 0 &&
                    newCustomer.money > orderByMoney.get(temp - 1).money &&
                    orderByMoney.get(temp - 1).id  != 0){
                temp--;
            }
            orderByMoney.add(temp, newCustomer);
        }
    }
}