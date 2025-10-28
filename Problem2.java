/*
503. Next Greater Element II
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
Use a monotonic decreasing stack, when a number which is greater than the one on the stack comes up then save the greater number for the element on stack and do this till there are no elements or elements on stack are greater than the incoming element.
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1); // Fill the default values

        for(int i = 0; i < 2 * n; i++){ // Traverse the list 2 times
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]){ //If the incoming element is greater than the element on stack
                result[st.peek()] = nums[i % n]; // Save the greater element in result and pop the element on stack
                st.pop();
            }
            if(i < n){ // Only add in first iteration
                st.push(i);
            }
        }

        return result;
    }
}