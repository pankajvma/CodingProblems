import java.math.BigInteger;
class FactorialDigitSum{
	public static void main(String[] args){
		BigInteger bigFact = new BigInteger("1");
		int factDigSum = 0;
		for(Integer  i =1; i <= 100; i++)
				bigFact = bigFact.multiply(new BigInteger(i.toString()));
		String factToString = bigFact.toString();
		for(int i =0; i < factToString.length(); i++)
			factDigSum += Character.getNumericValue(factToString.charAt(i));
		System.out.println(factDigSum);
	}
}