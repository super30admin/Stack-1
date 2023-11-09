// Time Complexity : O(n) where n is the size of nums array
// Space Complexity : O(n) in worst case all elements in nums will go in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(result, -1);

        for(int i = 0; i < 2*n; i++){
            if(i < n){
                while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                    result[s.pop()] = nums[i];
                }
                s.push(i);
            }
            if(i >= n){
                while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                    result[s.pop()] = nums[i%n];
                }
            }

        }

        return result;
    }
}
