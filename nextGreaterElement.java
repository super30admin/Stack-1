// Time complexity: O(N ^2)
// Space complexity: O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = -1;
            for(int j=1;j<nums.length;j++){
                if(nums[(i+j)%nums.length]>nums[i]){
                    result[i] = nums[(i+j)%nums.length];
                    break;
                }
            }
        }
        return result;
    }
}