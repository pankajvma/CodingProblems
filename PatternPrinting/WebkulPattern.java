import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
 class WebkulPattern
{
  public static void main (String[]args) throws FileNotFoundException {
  	System.setIn(new FileInputStream(new File("input.txt")));
  	System.setOut(new PrintStream(new File("output.txt")));
  	Scanner pv=new Scanner(System.in);
    int num=pv.nextInt();
	int i=num;
	int k,j;
	int count=0;
	if(num%2==0)
	{	
		System.out.print ("Enter Odd number.");
		return;
	}
    while ( i >= 1)
      {
		for (k = 1; k <=num-i; k+=2)
		  System.out.print (" ");
		for (k = 1; k <=i; k++)
			System.out.print ("*");
		for (k = 1; k <=num-i; k+=2)
		  System.out.print (" ");
		System.out.print("@");
		for (k = 1; k <=num-2; k++)
		  System.out.print (" ");
		System.out.print("@");
		for (k = 1; k <=num-i; k+=2)
		  System.out.print (" ");
		for (k = 1; k <=i; k++)
			System.out.print ("*");
		System.out.println ();
		i-=2;
		count++;
		if(i<1)
		{
			for(k=1;k<=num-count;k++)
			{
				for(j=1;j<=num;j++)
					System.out.print (" ");
				System.out.print("@");
				for(j=1;j<=num-2;j++)
					System.out.print (" ");
				System.out.println("@");
			}
		}
    }
	i=num;
	while ( i >= 1)
	{
		for (k = 1; k <=(num*3)-i; k+=2)
		  System.out.print (" ");
		for (k = 1; k <=i; k++)
			System.out.print ("@");
		System.out.println ();
		i-=2;
	}
	i=3;
	while ( i <= num)
	{
		for (k = 1; k <=(num*3)-i; k+=2)
		  System.out.print (" ");
		for (k = 1; k <=i; k++)
			System.out.print ("@");
		System.out.println ();
		i+=2;
	}
  }
}