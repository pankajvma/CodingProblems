/*
Problem 7 - 10001st Prime Number
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Prime10001
{
	public static void main (String[] args) 
	{
		int count=1;
		for(int i=2;count<=10001;i++)
		if(isPrime(i)){
			System.out.println(i);
			count++;
		}
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
/***************************Ans-104743**************************************/