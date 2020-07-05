/*
Problem 3 - Largest prime factor
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143?
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class PrimeFactor
{
	public static void main (String[] args) 
	{
		for(long i=2;i<600851475143L;i++)
		{
			if(600851475143L%i==0)
				if(isPrime(i))
				System.out.println(i);
		}
	}
	static boolean isPrime(long a)
	{
		double b=Math.sqrt(a);
		boolean q=true;
		for(long i=2;i<b;i++){
			if(a%i==0){	
				q=false;
				break;
			}
			else{
				q=true;
			}
		}
		return q;
	}
}
/***************************Ans-6857**************************************/