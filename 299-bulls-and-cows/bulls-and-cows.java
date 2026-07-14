class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        Map<Character, Integer> map = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for(int i=0; i<n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s == g) {
                bulls++;
            } else {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        for(int i=0; i<n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s != g && map.getOrDefault(g, 0) > 0) {
                cows++;
                map.put(g, map.get(g) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
} 