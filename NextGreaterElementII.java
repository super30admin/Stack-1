// Time Complexity : O(n+n) n for the input elements and n iteration for finding the next greater element from the stack
// Space Complexity : O(n) n for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// while iterating through the array, we store the indexes untill we find the greater element.
// if found, iterate back till you find greater element than current one ans store the respective element at each index.
// As it is a cirular array, go through it one more time to find the next greater for the last elements. (Total two iterations)
// we need to return -1 if the greater number is not found. Hence fill up the array before with -1 so that at the end the unprocessed ones will return -1.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0){
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);

        for(int i = 0; i < nums.length*2; i++) {
            int x = i % nums.length; // for the circular array index
            while(!st.isEmpty() && nums[x] > nums[st.peek()]){
                int pop = st.pop();
                output[pop] = nums[x];
            }

            if(output[x] == -1){
                st.push(x);
            }
        }

        return output;
    }
}