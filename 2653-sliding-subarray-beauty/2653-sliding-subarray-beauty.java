class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int []ans=new int [n-k+1];
        int[]freq=new int [51];
        for(int i=0;i<k;i++){
            if(nums[i]<0){
                freq[nums[i]+50]++;
            }
        }
        ans[0]=getSmall(freq,x);
        for(int i=k;i<n;i++){
            int out=nums[i-k];
            if(out<0){
                freq[out+50]--;
            }
            int in=nums[i];
            if(in<0){
                freq[in+50]++;
            }
            ans[i-k+1]=getSmall(freq,x);
        }
        
            return ans;
        
    }

    public int getSmall(int[] freq, int x) {
        int count = 0;
        for (int i = 0; i < freq.length; i++) {
            count += freq[i];
            if (count >= x) {
                return i - 50;//Map index back to the actual negative value
            }
        }
        return 0;//If there are fewer than x negative numbers

    }
}