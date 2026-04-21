// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int n = nums.length;

//         HashMap<Integer, Integer> map = new HashMap<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>(
//             (a, b) -> map.get(a) - map.get(b));

//         for (int i = 0; i < n; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }

//         int[] res = new int[k];

//         for (int key : map.keySet()) {
//             pq.add(key);   
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         int i = 0;

//         while (!pq.isEmpty()) {
//             res[i++] = pq.poll();  
//         }

//         return res;
//     }
// }

//  Bucket Sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(key);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[idx++] = num;
                    if (idx == k)
                        break;
                }
            }
        }

        return res;
    }
}