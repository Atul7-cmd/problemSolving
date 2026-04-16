// class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         return solve(0, s, dp);
//     }

//     int solve(int i, String s, int[] dp) {
//         if (i == s.length()) return 1;     
//         if (dp[i] != -1) return dp[i];      

//         int ways = 0;

        
//         if (isValid(s.substring(i, i + 1))) {
//             ways += solve(i + 1, s, dp);
//         }

        
//         if (i + 1 < s.length() && isValid(s.substring(i, i + 2))) {
//             ways += solve(i + 2, s, dp);
//         }

//         return dp[i] = ways;
//     }

//     boolean isValid(String s) {
//         if (s.length() == 1)
//             return s.charAt(0) != '0';

//         int n = Integer.parseInt(s);
//         return n >= 10 && n <= 26;
//     }
// }

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1;  ////Tabulation

        for (int i = n - 1; i >= 0; i--) {

            // take 1 digit
            if (isValid(s.substring(i, i + 1))) {
                dp[i] += dp[i + 1];
            }

            // take 2 digits
            if (i + 1 < n && isValid(s.substring(i, i + 2))) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    boolean isValid(String s) {
        if (s.length() == 1)
            return s.charAt(0) != '0';

        int n = Integer.parseInt(s);
        return n >= 10 && n <= 26;
    }
}
