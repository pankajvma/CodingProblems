import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SNCKYEAR
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
			Scanner sc = new Scanner(System.in);
			short testCases=sc.nextShort(); 
			for(short i=0;i<testCases;i++){
				short searchYear=sc.nextShort();
				if(searchYear==2010||searchYear==2015||searchYear==2016||searchYear==2017||searchYear==2019)
					System.out.println("HOSTED");				
				else
					System.out.println("NOT HOSTED");
			}
		}
		catch(Exception e){}
	}
}
