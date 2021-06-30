/*
Desc : We use a stack to store elements while iterating through if stack not empty & incoming element is greater than top of stack,
We push any eleement in stack only once.
Time Complexity : O(n)
Space Complexity : O(n)
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int [n];
        if(nums == null || nums.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        
        //iterate the array twice
        for(int i = 0; i < 2*n; i++){
            //if stack not empty & incoming element is greater than top of stack
            while((!st.isEmpty()) && nums[i % n] > nums[st.peek()]){
                int index = st.pop();
                result[index] = nums[i % n];
            }
            //push the elements in stack only once
            if(i < n){
                st.push(i % n);
            }
        }
        return result;
    }
}
