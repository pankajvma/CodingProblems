import java.util.*;
import java.lang.*;
import java.io.*;

class CUTBOARD
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{
    		short no_of_cuts=0, test_cases=0,n=0,m=0, tCount=0;
    		Scanner sc=new Scanner(System.in);
    		test_cases= sc.nextShort();
    		for(int i=0;i<test_cases;i++){
    		    n= sc.nextShort();
    		    m= sc.nextShort();
    		    System.out.print((n-1)*(m-1));
    		    if(tCount==(test_cases-1))
					    break;
				    System.out.print("\n");
		    }
	    }
		    catch(Exception e)
		    {
		        
		    }
	}
}
