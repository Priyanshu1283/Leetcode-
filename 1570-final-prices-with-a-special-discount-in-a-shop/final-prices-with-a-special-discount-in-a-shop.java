class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        
        arr[prices.length-1] =prices[prices.length-1];
        for(int i=0; i< prices.length; i++){
            for(int j=i + 1; j<prices.length; j++){
                if(prices[j] <= prices[i]){
                    arr[i] = prices[i] - prices[j];
                    break;
                }else{
                    arr[i] = prices[i];
                }
            }
        }
        return arr;
    }
}