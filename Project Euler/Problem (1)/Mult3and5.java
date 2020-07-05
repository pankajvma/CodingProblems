/*
Problem 1 - Multiples of 3 and 5
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/
public class Mult3and5
{
    public static void main(String[] args) {
		int result=0;
		long startTime=System.nanoTime();		//To check execution time
		for(int i=0;i<1000;i++){ 
			if(i%3==0&&i%5==0)
				result+=i;	
			else if(i%3==0&&i%5!=0)  
				result+=i;
			else if(i%3!=0&&i%5==0)  
				result+=i;
		}
		System.out.println(result );
		long endTime=System.nanoTime();		//To check execution time
		long totalTime=endTime-startTime;
		System.out.printf("Execution Time: %.2f milli seconds",(float)totalTime/1000000);
      }
}
/***************************Ans-233168**************************************/