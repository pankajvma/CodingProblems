import java.util.*;
import java.lang.*;
import java.io.*;

class CNote
{
	public static void main (String[] args) throws IOException
	{
	    try {
	        Scanner sc=new Scanner(System.in);
    		int noOfTestCases=0,reqPage=0,availPage=0,budget,noOfNotebooks;
    		noOfTestCases=sc.nextInt();
    		boolean lucky=false;
    		for(int i=1;i<=noOfTestCases;i++)
    		{
    			lucky=false;
    			reqPage=sc.nextInt();
    			availPage=sc.nextInt();
    			reqPage=reqPage-availPage;
    			budget=sc.nextInt();
    			noOfNotebooks=sc.nextInt();
    			Notebook[] nb=new Notebook[noOfNotebooks];
    			for(int j=0;j<noOfNotebooks;j++)
    			{
    				nb[j]=new Notebook();
    				nb[j].pages=sc.nextInt();
    				nb[j].cost=sc.nextInt();
    			}
    			for(int j=0;j<noOfNotebooks;j++)
    			{
    				if(nb[j].pages>=reqPage&&nb[j].cost<=budget)
    					lucky=true;
    			}
    			if(lucky)
    				System.out.println("LuckyChef");
    			else
    				System.out.println("UnluckyChef");
    		}
	    } catch(Exception e) {
	        return;
	    } 
		
	}
}
class Notebook
{
	int pages,cost;
}
