class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx[] = new int[n];
        int prefixGcd[] = new int[n];
        mx[0] = nums[0];
        for(int i=1; i<n; i++){
            mx[i] = Math.max(nums[i] , mx[i-1]);
        }
        for(int j =0; j<n; j++){
            prefixGcd[j] = findGCD(nums[j] , mx[j]);
        }
        Arrays.sort(prefixGcd);
        int i=0, j=n-1;
        long sum =0;
        while(i<j){
            sum += findGCD(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;

    }
    public static int findGCD(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}