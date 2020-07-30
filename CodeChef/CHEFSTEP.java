import java.util.*;
import java.lang.*;
import java.io.*;

class CHEFSTEP
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			Scanner sc = new Scanner(System.in);
			int testCases=sc.nextInt(); 
			String build="";
			for(int i=0;i<testCases;i++){
				int distance = sc.nextInt();
				int stepLength = sc.nextInt();
				build="";
				for(int j=0; j<distance; j++){
					int dPath=sc.nextInt();
					if(dPath%stepLength==0)
						build+="1";
					else
						build+="0";
				}
				System.out.println(build);
			}
		}
		catch(Exception e){}
	}
}
