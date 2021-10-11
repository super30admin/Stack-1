// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for(int i= 0; i<2 *n; i++){
            while(!s.isEmpty() && nums[i %n] > nums[s.peek()]){
                int idx = s.pop();
                result[idx] = nums[i %n];
            }
            if(i<n){
                s.push(i);
            }
        }
        return result;
    }
}

