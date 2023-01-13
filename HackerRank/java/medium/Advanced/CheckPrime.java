// https://www.hackerrank.com/challenges/prime-checker/problem
package hackerrank.java.medium.Advanced;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import static java.lang.System.*;
import static java.lang.Math.*;


class Prime{
    public void checkPrime(int... a){
        StringBuilder strBld = new StringBuilder();
        for(int i = 0; i < a.length; i++){
            if(isPrime(a[i])){
                strBld.append(a[i]+" ");
            }
        }
        out.println(strBld.toString()); //Static System class imported at line no 7
    }
    
    public boolean isPrime(int a){
        if(a == 1) return false;
        for(int i = 2; i <= pow(a, 0.5); i++){
            if(a % i == 0){
                return false;
            }
        } return true;
    }
}

public class CheckPrime {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in)); //Static System class imported at line no 7
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}