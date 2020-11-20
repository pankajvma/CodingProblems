import java.util.*;
import java.lang.*;

class CUTBOARD
{
	public static void main (String args[])throws java.lang.Exception
	{
	    try{
        	Scanner sc=new Scanner(System.in);
        	short test_cases= sc.nextShort();
        	for(int i=0;i<test_cases;i++){
        	    short n= sc.nextShort();
        	    short m= sc.nextShort();
        	    System.out.println((--n)*(--m));
    		}
	    }
	    catch(Exception e){}
	}
}
