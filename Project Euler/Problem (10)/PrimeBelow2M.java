/*
Problem 7 - Summation of Primes

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class PrimeBelow2M
{
	public static void main (String[] args) 
	{
		long sum=0;
		for(int i=2;i<=2000000;i++)
		if(isPrime(i)){
			sum+=i;
			System.out.println(i);
		}
		System.out.println("Sum of primes below 2M: "+sum);
	}
	static boolean isPrime(long a)
	{
		double b=Math.sqrt(a);
		boolean q=true;
		for(long i=2;i<=b;i++){
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
/***************************Ans-142913828922**************************************/