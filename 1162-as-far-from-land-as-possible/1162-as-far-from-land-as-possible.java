class Pair{
    int i;
    int j;
    int d;
    Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
       int[]dx={1,-1,0,0};
       int[]dy={0,0,1,-1};
       int n=grid.length;
       int m=grid[0].length;
       int count0=0;
       int count1=0;
       Queue<Pair> q=new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                q.offer(new Pair(i,j,0));
            }
            if(grid[i][j]==1){
                count1++;
            }else{
                count0++;
            }
         }
       }
       int maxD=0;
       while(!q.isEmpty()){
       Pair curr= q.poll();
        int r=curr.i;
        int c=curr.j;
        int di=curr.d;

        maxD=Math.max(maxD,di);

         for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];

                 if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0) {
                   
                    q.offer(new Pair(nr, nc, di + 1));
                    grid[nr][nc] = 1;
                }
             }
          }
          if(count0==0 ||count1==0)return -1;
          return maxD;
    }
}