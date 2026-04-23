class Pair {
    int r;
    int c;
    int d;

    Pair(int i, int j, int d) {
        this.r = i;
        this.c = j;
        this.d = d;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dirx = { 1, -1, 0, 0, 1, 1, -1, -1 };
        int[] diry = { 0, 0, 1, -1, 1, -1, 1, -1 };
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        Queue<Pair> pq = new LinkedList<>();
        if (grid[0][0] == 0) {
            pq.add(new Pair(0, 0, 1));
            grid[0][0] = 1;
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.r;
            int j = p.c;
            int di = p.d;

            if (i == n - 1 && j == m - 1)
                return di;

            for (int k = 0; k < 8; k++) {
                int nr = i + dirx[k];
                int nc = j + diry[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0) {
                    pq.add(new Pair(nr, nc, di + 1));
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
    }
}