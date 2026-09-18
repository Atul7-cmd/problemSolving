class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        StringBuilder sb = new StringBuilder();

        backtrack(digits, 0, sb, ans, map);

        return ans;
    }

    private void backtrack(String digits, int index,
                           StringBuilder sb,
                           List<String> ans,
                           String[] map) {

        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            sb.append(ch);

            backtrack(digits, index + 1, sb, ans, map);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}