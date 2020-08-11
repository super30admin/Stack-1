// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 /* 
 Stack
 1. Check if peek is less than incoming and if true peek elements ans = pop .
 2. Push all elements.
 3. Instead of elements, push elements index, so that we can keep track of temperatures to assign result.
 4. As it is circular, visit the array two times and take modulo while using the index other than pushing.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        int n = nums.length;
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i< (2*n)-1;i++){
            while(!st.isEmpty() && nums[i%n] > nums[(st.peek())%n]){
                int x = st.pop();
                result[x%n] = nums[i%n];
            }
            st.push(i);
        } 
        return result;       
    }
}