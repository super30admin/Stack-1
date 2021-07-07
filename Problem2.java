// Time Complexity - O(n) where n is the number of elements in the array .precisely it is O(3n) since we are traversing through the array twice
// Space Complexity - O(n) ; the space used by the stack worst case will have all elements in the stack

// This Solution worked on LeetCode

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0)    return result;
        int n = nums.length;
        Arrays.fill(result,-1); // Initialize the result with -1. since the element with no greater integer will have -1 as output
        Stack<Integer> st = new Stack<>();
        for(int i=0;i< 2*n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){ // Check if the stack is not empty and element on the top of stack is smaller than the traversed element.
               if(result[st.peek()] == -1)    // If the output is -1 it means the greater integer is not found yet and insert the output in the result array
                    result[st.pop()] = nums[i%n]; 
            }
            if(i < n) st.push(i); // push the elements in the first iteration of 0 to n. So that the elements need not be processed repeatedly. 
        }
        return result;
    }
}
