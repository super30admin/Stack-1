// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * We use a monotonic decreasing stack and resolve all the elements in the stack which are smaller than the current element.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //using monotonic decreasing stack
        Stack<Integer> st = new Stack();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        boolean circular = false;
        for( int i = 0; i < nums.length; i++){
            // if peek is less than the curr num, pop the peek and insert the element
            while(!st.empty() && nums[st.peek()] < nums[i]){
                int index = st.pop();
                result[index] = nums[i];
            }
            if(!circular) st.push(i);
            System.out.println(st.peek());
            if(i == nums.length-1 && !circular){
                i = -1;
                circular = true;
            }
        }
       
        return result;
    }
}