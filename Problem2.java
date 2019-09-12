//Brute Force Approach
// Time : O(n*n)
// Space: O(n)

//Approach:
// 1. For each element find next greater element by starting from next index to ending at previous index and store it in new array , else store -1.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            boolean b = false;
            for(int k =1;k<nums.length;k++){
                int j = (i+k)%nums.length;
                if(nums[j]>nums[i]){
                    result[i] = nums[j];
                    b = true;
                    break;
                }
            }
            if(!b)  result[i] = -1;
        }
        return result;
    }
}
