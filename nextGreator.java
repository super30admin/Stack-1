// Time Complexity : O(2*N) where N is the length of the array 
// Space Complexity : O(N) where N is the number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    1. Add the unresolved elements (Elements who haven't found numbers greator than themself to a stack)
    2. For each element, pop the stack and check if the popped element is smaller than the current element.
    3. If it is smaller, then push the current element to the stack and change the index of the smaller element to the current element.
*/


// Your code here along with comments explaining your approach
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(nums == null || n == 0) return result;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);
        st.add(0);
        for(int i = 1; i < 2*n; i ++){
            if(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                    int temp = st.pop();
                    result[temp] = nums[i%n];
                }
            }
              if(i < n) {
                 st.add(i); 
              }
        }
        return result;
    }
}
