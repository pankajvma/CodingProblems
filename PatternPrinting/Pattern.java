import java.util.*;
 class Pattern
{
  public static void main (String[]args)
  {Scanner pv=new Scanner(System.in);
    int num=pv.nextInt();
    for (int i = 0; i <= num; i++)
      {
		for (int k = 0; k <= num - i; k++)
		  System.out.print (" ");
		for (int j = 0; j < i; j++)
			System.out.print ("X");
		System.out.println ("");
      }
  }
}