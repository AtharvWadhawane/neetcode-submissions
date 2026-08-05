class Solution {
    public int maxProfit(int[] prices) {
       int bmin = Integer.MAX_VALUE;
       int profit = 0;

       for(int i=0;i<prices.length;i++){
            if(prices[i]<bmin){
                bmin = prices[i];
            }
            else if(prices[i]-bmin>profit){
                profit = prices[i] - bmin;
            }
       }
       return profit;
    }
}
