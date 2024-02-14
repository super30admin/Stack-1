/* Time Complexity : O(3n) ~ O(n)
 *   n - length of array - nums  */
/* Space Complexity : O(n) 
 * stack size */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Monotonic decreasing stack

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2*n; i++){            
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                res[popped] = nums[i%n];
            }
            if(i < n)
                st.push(i);
        }        
        return res;
    }
}