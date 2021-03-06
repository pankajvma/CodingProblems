/*
Problem 2 - Even Fibonacci numbers
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.*/

import java.util.*;
import java.lang.*;
import java.io.*;

class EvenFibonacci
{
	public static void main (String[] args) throws IOException
	{
		fib();
	}
	static void fib()
	{
		long first=1,second=2,temp,sum=0;
		for(int i=0;first<4000000;i++)
		{
			System.out.print(first+"  ");
			temp=first+second;
			first=second;
			second=temp;
			if(first%2==0)
			sum+=first;
		}
		System.out.println();
		System.out.println(sum);
	}
}
/***************************Ans-4613732**************************************/