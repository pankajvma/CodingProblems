// https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
package hackerrank.java.easy.ExceptionHandling;

import java.io.*;
import java.util.*;

public class TryCatch {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);        
        try{
            int x = scn.nextInt();
            int y = scn.nextInt();
            System.out.print(x/y);            
        } catch(InputMismatchException e){
            System.out.print("java.util.InputMismatchException");
        } catch(Exception e){
            System.out.print(e.toString());
        }
    }
}
