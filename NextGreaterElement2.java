// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class NextGreaterElement2 {
    // Brute Force
    public int[] nextGreaterElements(int[] nums) {
        int[] doubleArray = new int[nums.length * 2];
        int[] output = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            doubleArray[i] = nums[i];
            doubleArray[nums.length + i] = nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < doubleArray.length; j++){
                if(doubleArray[j] > nums[i]){
                    output[i] = doubleArray[j];
                    break;
                } else {
                    output[i] = -1;
                }
            }
        }

        return output;
    }
}
