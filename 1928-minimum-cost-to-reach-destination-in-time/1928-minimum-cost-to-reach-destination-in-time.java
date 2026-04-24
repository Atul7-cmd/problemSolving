import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0], v = e[1], t = e[2];
            graph[u].add(new int[]{v, t});
            graph[v].add(new int[]{u, t});
        }

        //best (minimum) time to reach this node
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        // PQ: {cost, node, time}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{passingFees[0], 0, 0});
        minTime[0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int time = curr[2];

            // reached destination
            if(node == n - 1) return cost;

            // explore neighbors
            for(int[] nei : graph[node]){
                int next = nei[0];
                int newTime = time + nei[1];

                if(newTime > maxTime) continue;

                // only proceed if this path is better in time
                if(newTime < minTime[next]){
                    minTime[next] = newTime;
                    int newCost = cost + passingFees[next];
                    pq.offer(new int[]{newCost, next, newTime});
                }
            }
        }

        return -1;
    }
}