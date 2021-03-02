// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a Stack to record elements while checking if they satisfy the condition, where the top of the stack is less than the current element. Go through the array twice, as it is a circular array. Keep popping from the stack till a resolution is found. Finally, add the current element to the stack for only the first n elements.

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        if(nums.length == 0) return result;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < 2 * nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i % nums.length]){
                int indx = st.pop();
                result[indx] = nums[i % nums.length];
            }
            
            if(i < nums.length)
                st.push(i % nums.length);
        }
        
        return result;
    }
}
