import java.lang.Math;
class HeighestDivisibleTriangleNumber{
	public static void main(String[] args){
		try{
			triangleNo();
		}
		catch(Exception e){System.out.println(e);}

	}
	public static long noOfDivisor(long n){
		long divNo =1, count =0;
		if(isPrime(n)) return 2;
		for(long loop = 2; loop <= 20; loop++ ){
			if(isPrime(loop)){
				long i =1;
				count = 0;
				while(n % Math.pow(loop, i) == 0){
					count++; i++;
				}
				divNo *= (count+1);
			}
		}
		return divNo;
	}
	public static boolean isPrime(long n){
		if(n == 2)
			return true;
		for(long i =2; i <= Math.sqrt(n); i++){
			if( n % i == 0)
				return false;
		}
		return true;
	}
	public static void triangleNo(){
		long tNo = 0;
		for(long i =1; noOfDivisor(tNo) < 500; i++)
			tNo += i;
		System.out.println(noOfDivisor(tNo)+" of "+tNo);
	}
}
