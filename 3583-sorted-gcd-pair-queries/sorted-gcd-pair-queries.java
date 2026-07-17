class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        // Find maximum value
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // cnt[g] = how many numbers are divisible by g
        long[] cnt = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }

        // gcdCount[g] = number of pairs whose GCD is exactly g
        long[] gcdCount = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long pairs = cnt[g] * (cnt[g] - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                pairs -= gcdCount[multiple];
            }

            gcdCount[g] = pairs;
        }

        // Prefix sum
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        // Answer queries
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long k = queries[i] + 1;   // queries are 0-indexed

            int low = 1;
            int high = max;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = low;
        }

        return ans;
    }
}