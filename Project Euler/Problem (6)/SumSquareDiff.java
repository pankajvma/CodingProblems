/*
Problem 6 - Sum square difference
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 and 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
public class SumSquareDiff
{
  public static void main(String[] args) {
      diff(sumOfSquares(),squareOfSum());
    }
    static double sumOfSquares()
    { double sum=0;
        for(int i=1;i<=100;i++)
         sum+=Math.pow(i,2);
         return sum;
    }
    static double squareOfSum()
    { double sum=0;
        for(int i=1;i<=100;i++)
         sum+=i;
         return Math.pow(sum,2);
    }
    static void diff (double a,double b)
    {
        System.out.print(b-a);
        
    }
}
/***************************************************Ans-**************************************************************/