class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b));

       
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] res = new int[k];

        
        for (int key : map.keySet()) {
            pq.add(key);   
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;


        while (!pq.isEmpty()) {
            res[i++] = pq.poll();  
        }

        return res;
    }
}