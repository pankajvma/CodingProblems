// https://www.hackerrank.com/challenges/java-1d-array/problem
package hackerrank.java.medium.DataStrucutures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class OneDArrayPart2 {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        VirtualPlayer v = new VirtualPlayer(leap,game);
        v.tick();
        return v.winnable;

        /*84 14 Yes 49
        0 0 0 0 0 1 0 1 1 1 1 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 0 0 1 1 0 0 1 0 0 1 1 1 1 0 0 0 0 0 0 1 0 0 0 0 0 1 1 0 0 1 1 1 0 0 0 0 1 0 0 1 1 1 0 0 1 1 1 1 1 1 1 1 0 1 1 0 0 0

        82 19 Yes 80
        0 0 0 0 0 1 0 1 0 0 1 1 1 0 1 0 1 0 1 0 0 1 0 0 1 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 1 1 1 0 0 1 1 0 1 1 0 0 1 0 1 0 0 0 0 0 0 1 1 0 1 0 0 0 0 0 0 0 1 1 0 0 0 1 0 1 0
        */
        
    }
    
    
    static class VirtualPlayer {
        private int pos = 0;
        private int lp;
        private int[] map;
        boolean winnable = false;
        public VirtualPlayer(int lp, int[] map){
            this.lp = lp;
            this.map = map;
        }
        private void moveup(){
            if(map[pos+1]==0){
                pos++;
                tick();
            }
        }
        
        private void movedown(){
            if((pos - 1) >= 0 && map[pos - 1] == 0){
                map[pos] = 1;
                pos--;
                tick();
            }
        }
        
        private void jump(){
            if((pos + lp) < map.length){
                if(map[pos + lp] == 0){
                    int posold = pos;
                    pos = pos + lp;
                    tick();
                    pos = posold;
                }
            }
        }
        
        void tick() {
            
            if(pos == (map.length - 1) || ((pos + lp) >= map.length)){
                winnable = true;
            }
            else {
                this.moveup();
                if(lp!=0){
                    this.jump();
                }
                this.movedown();
            }
        }
    }
    

    public static void main(String[] args) {
        try{
        Scanner scan = new Scanner(new File("io\\OneDArrayPart2_input.txt"));
        System.setOut(new PrintStream(new File("io\\OneDArrayPart2_output.txt")));
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();}catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
    }
}
