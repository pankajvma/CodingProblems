import java.math.BigInteger;
import java.lang.Math;
class PowerDigitSum{
	public static void main(String[] args) {
		BigInteger bigNumber = new BigInteger("1");
		BigInteger temp = new BigInteger("2");
		int sum= 0;
		for(Integer i =1; i <= 1000; i++)
			bigNumber = bigNumber.multiply(temp);
		String convertedNum = bigNumber.toString();
		for(int i= 0; i < convertedNum.length(); i++)
			sum += Character.getNumericValue(convertedNum.charAt(i));
		System.out.println(sum);
	}
}