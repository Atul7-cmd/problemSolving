class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        Long[][] dp = new Long[n][m];

        return (int) solve(0, 0, s, t, dp);
    }

    private long solve(int i, int j, String s, String t, Long[][] dp) {
        
        // base cases
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        long ans = 0;

        if (s.charAt(i) == t.charAt(j)) {
            // take + skip
            ans = solve(i + 1, j + 1, s, t, dp) 
                + solve(i + 1, j, s, t, dp);
        } else {
            // skip
            ans = solve(i + 1, j, s, t, dp);
        }

        return dp[i][j] = ans;
    }
}