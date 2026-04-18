// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         for (Integer key:map.keySet()){
//             int value=map.get(key);
//             if(value>=2){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int [] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) return true;
         
        }
        return false;
    }
}