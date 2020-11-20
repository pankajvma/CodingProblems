import java.util.*;

class LECANDY
{
	public static void main (String[] args)
	{
	    try 
	    {
	        Scanner sc=new Scanner(System.in);
		    int testCase=sc.nextInt(),noOfEleph,noOfCandies,total;
    		for(int i=1;i<=testCase;i++)
    		{
        		noOfEleph=sc.nextInt();
        		noOfCandies=sc.nextInt();
    			int[] A=new int[noOfEleph];
    			for(int j=0;j<noOfEleph;j++)
    				A[j]=sc.nextInt();
    			total=0;
    			for(int j=0;j<noOfEleph;j++)
    				total+=A[j];
    			if(total>noOfCandies)
    				System.out.println("No");
    			else
    				System.out.println("Yes");
    		}
	    } 
	    catch(Exception e) 
	    {
	        return;
	    }
		
	}
}
