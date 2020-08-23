import java.io.BufferedReader;
import java.io.InputStreamReader;
class MAX2{
	public static void main(String args[])throws Exception{
		try{
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			bfr.readLine();
			String binaryString = bfr.readLine();
			int pwr = 0;
			for(int i =binaryString.length()-1; i >= 0; i--)
				if(binaryString.charAt(i) == '0')
					pwr++;
				else break;
			System.out.println(pwr);
		}catch(Exception e){}

	}
}

/* Alternate Solution

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
class MAX2{
	public static void main(String args[])throws Exception{
		try{
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			int test = Integer.parseInt(bfr.readLine());
			String binaryString = bfr.readLine();
			int number = Integer.parseInt(binaryString, 2);
			int pwr = 0;
			while(number % Math.pow(2, pwr) == 0)
				pwr++;
			System.out.println(number);
			System.out.println(pwr - 1);
		}catch(Exception e){}

	}
}*/
