/*
Problem 5 - Smallest Multiple

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class SmallestMultiple
{
	static int count=0,num;
	public static void main (String[] args) throws IOException
	{
		num=1;
		long startTime=System.nanoTime();		//To check execution time
		while(!div(num))
		{
			num++;
		}
		System.out.println(num);
		long endTime=System.nanoTime();		//To check execution time
		long totalTime=endTime-startTime;
		System.out.printf("Execution Time: %.2f milli seconds",(float)totalTime/1000000);
	}
	static boolean div(int a)
		{
			count=0;
			for(int i=11;i<=20;i++)
			{
				if(a%i==0)
					count++;
			}
			if(count==10)
					return true;
				else
					return false;
		}
	
}
/***************************Ans-232792560**************************************/