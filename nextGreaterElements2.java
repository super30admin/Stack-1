//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Iterate twice the size of the array to satisfy circular array condition. At
 * each iteration, do i%n so that i remains in length of n. If the peek <
 * current element, update peek index in answer array with the current element
 * and then push the current index % n. Return answer array.
 *
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //null
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int curr = st.pop();
                result[curr] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
            if(i>=n && st.peek() == i%n ) break;
        }
        return result;
    }
}
