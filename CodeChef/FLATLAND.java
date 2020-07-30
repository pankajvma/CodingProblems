import java.util.Scanner;

class FLATLAND{
	public static void main(String[] args) throws java.util.NoSuchElementException{
		try{
		    Scanner sc = new Scanner(System.in);
    		int side = 1, sideSquare = 0, count = 0;
    		int testCases= sc.nextInt();
    		for(int i=0; i<testCases; i++){
    			count = 0;
    			int noOfCircles = sc.nextInt();
    			while(noOfCircles != 0){
    				sideSquare = side*side;
    				if(noOfCircles<sideSquare){
    					noOfCircles -= (side-1)*(side-1);
    					side = 1;
    					count++;
    				}
    				else side++;
    			}
    			System.out.println(count);
    		}
		}
		catch (Exception e){return ;}
	}
}
