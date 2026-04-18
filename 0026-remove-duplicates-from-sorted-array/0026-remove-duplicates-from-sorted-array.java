class Solution {
    public int removeDuplicates(int[] nums) {
       int i=0;
       for(int j=1;j<nums.length;j++){
        if(nums[i]!=nums[j]){
             i++;//pehle increment krna isliye jaruri hai 
                 //kyoki i last unique element par point kar  
                 //rha hai to nhi value agr aayi to uske aage 
                 //duplicate par aayegi
            nums[i]=nums[j];
            }
       }
       return i+1;
    }
}