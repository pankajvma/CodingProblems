/*
Problem 4 - Largest Palindrome Product
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.*/

import java.util.*;
import java.lang.*;
import java.io.*;

class LargestPalin
{
	static int grt=0;
	public static void main (String[] args) throws IOException
	{
		for(int i=100;i<1000;i++)
			for(int j=100;j<1000;j++)
				if(palin(i*j))
					compare(i*j);
		System.out.println(grt);
	}
	static boolean palin(int num)
	{
		int rev=0,temp=num;
		while(num!=0)
		{
			rev=rev*10+(num%10);
			num=num/10;
		}
		if(rev==temp)
			return true;
		return false;

	}
	static void compare(int num)
	{
		if(num>grt)
			grt=num;
	}
}
/***************************Ans-906609**************************************/