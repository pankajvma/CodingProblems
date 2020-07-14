import java.util.Scanner;
import java.io.*;

class CRDGAME
{
	public static void main(String args[])throws IOException{
		try{
		    Scanner sc= new Scanner(System.in);
			int testCases=sc.nextInt();
			byte no_of_rounds=0, i=0, A_points=0,B_points=0;
			int card_A=0, card_B=0, A_power=0, B_power=0, tCount=0;
			while(tCount<testCases){
				A_points=0;
				B_points=0;
				no_of_rounds= sc.nextByte();
				i=0;
				while(i<no_of_rounds){
					card_A=sc.nextInt();
					A_power=calc_power(card_A);
					card_B=sc.nextInt();
					B_power=calc_power(card_B);
					if(A_power>B_power)
						A_points++;
					else if(B_power>A_power)
						B_points++;
					else{
						A_points++;
						B_points++;
					}	
					i++;
				}
				if(A_points>B_points){
					System.out.print("0"+" "+A_points);
					if(tCount==(testCases-1))
					break;
					System.out.print("\n");
				}
				else if(B_points>A_points){
					System.out.print("1"+" "+B_points);
					if(tCount==(testCases-1))
					break;
					System.out.print("\n");
				}
				else{
					System.out.print("2"+" "+A_points);
					if(tCount==(testCases-1))
					break;
					System.out.print("\n");
				}
				tCount++;
			}
			sc.close();
		}
		catch(Exception e){
			return;
		}
	}
	public static int calc_power(int x){
		int sum=0;
		while(x!=0){
			sum+=x%10;
			x/=10;
		}
		return sum;
	}	
}