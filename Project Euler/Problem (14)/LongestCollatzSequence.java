class LongestCollatzSequence{
	public static void main(String[] args){
		long count =1, number = 0;
		for(int n =2; n <= 1000000 ; n++){
			long num = n;
			long currentCount = 1;
			while(num != 1){
				if(num%2 == 0)
					num /= 2;
				else
					num = (3 * num) + 1;	
				currentCount++;
				if(currentCount > count){
					number  = n;
					count = currentCount;
					continue;
				}
			}
		}
		System.out.println(number);
	}
}