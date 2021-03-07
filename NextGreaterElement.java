class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        
        int[] result = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            int startIndex = i+1;
            int curr = nums[i];
            boolean found = false;
            while(i != startIndex){
                if(startIndex == nums.length){
                    startIndex = 0;
                    continue;
                }
                if(nums[startIndex] > curr){
                    result[i] = nums[startIndex];
                    found = true;
                    break;
                }else{
                    startIndex++;
                }
            }
                        
            if(!found) result[i] = -1;
        }
        
        return result;
        
        
     }
}