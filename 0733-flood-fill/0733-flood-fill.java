class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;

        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] img, int r, int c, int orig, int color) {
        if(r < 0 || c < 0 || r >= img.length || c >= img[0].length)
            return;
        if(img[r][c] != orig) return;

        img[r][c] = color;

        dfs(img, r+1, c, orig, color);
        dfs(img, r-1, c, orig, color);
        dfs(img, r, c+1, orig, color);
        dfs(img, r, c-1, orig, color);
    }
}