/*
Problem 9 - Special Pythogorean Triplet

*/
class PythTriple
{
	public static void main(String args[])
	{
		int m,n;
		double eq=0;
		for(m=2;;m++)
			for(n=1;n<m;n++)
			{
				eq=Math.pow(m,2)+m*n;
				if(eq==500)
				{	
					calc(m,n);
					return;
				}
			}
	}
	static void calc(int m,int n)
	{
		System.out.println(m+" "+n);
		double a=Math.pow(m,2)-Math.pow(n,2);
		double b=2*m*n;
		double c=Math.pow(m,2)+Math.pow(n,2);
		System.out.println(a+" "+b+" "+c);
		System.out.printf("%.2f",a*b*c);
	}
}