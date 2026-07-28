class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        // Build left half
        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'a'));
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}