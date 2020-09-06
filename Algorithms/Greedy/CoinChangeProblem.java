class CoinChangeProblem{
	public static void main(String args[]){
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		int amount = 5285;
		int count =0;
		int index = coins.length - 1;
		/*while(amount != 0){
			if(amount >= coins[index]){
				amount -= coins[index];
				count++;
			}
			else index--;
		}*/
		while(amount != 0){
			count += amount/coins[index];
			amount = amount%coins[index--];
			//System.out.println("Remaing: "+amount+", count: "+count);
		}
		System.out.println(count);
	}
}
