class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer> >ans=new ArrayList<>();
        solve(0,candidates,target,ans,new ArrayList<>());

        return ans;
        
    }
    public void solve(int i,int [] candidate,int target,List<List<Integer>> ans,List<Integer> curr){
        if(i==candidate.length) {
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(candidate[i]<=target){
            curr.add(candidate[i]);
            solve(i,candidate,target-candidate[i],ans,curr);
            curr.remove(curr.size()-1);
        }
        solve(i+1,candidate,target,ans,curr);
    }
}