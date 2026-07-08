class Solution {
    static final long MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();
        int q = queries.length;

        long[] prefixSum = new long[n + 1];
        long[] prefixX = new long[n + 1];
        int[] prefixNZ = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            int digit = s.charAt(i - 1) - '0';

            prefixSum[i] = prefixSum[i - 1] + digit;

            if (digit != 0) {
                prefixNZ[i] = prefixNZ[i - 1] + 1;
                prefixX[i] = (prefixX[i - 1] * 10 + digit) % MOD;
            } else {
                prefixNZ[i] = prefixNZ[i - 1];
                prefixX[i] = prefixX[i - 1];
            }
        }

        int[] ans = new int[q];

        for (int idx = 0; idx < q; idx++) {

            int l = queries[idx][0] + 1;
            int r = queries[idx][1] + 1;

            long sum = prefixSum[r] - prefixSum[l - 1];

            int nzRange = prefixNZ[r] - prefixNZ[l - 1];

            long rightVal = prefixX[r];
            long leftVal = prefixX[l - 1];

            long x = (rightVal - (leftVal * pow10[nzRange]) % MOD + MOD) % MOD;

            ans[idx] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}
