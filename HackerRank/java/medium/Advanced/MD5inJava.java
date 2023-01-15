// https://www.hackerrank.com/challenges/java-md5/problem
package hackerrank.java.medium.Advanced;

import java.util.*;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class MD5inJava {

    public static void main(String[] args) {
        System.out.println(printMD5(new Scanner(System.in).next()));        
    }
    
    public static String printMD5(String message){
        try{
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(message.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}