class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven =0;
        for(int i=1; i<= 2*n; i++){
            if(i % 2 == 0){
                sumEven += i;
            }else{
                sumOdd += i;
            }
        }
        return GCD(sumEven, sumOdd);
    }
    public static int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}