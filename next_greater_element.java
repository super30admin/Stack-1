// Time Complexity : O(n), where n is the size of the input array ( exactly O(4n) -> O (2n) traversals for a circular array, 
                    // O(n) adding -1 initially to array)
// Space Complexity : O(n), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Create a stack(the numbers in the stack are the one's for which we have to find the next greater element) and push index 0 (
        //to start the search)
//2. Iterate over the input array 2 times (circular array) and "WHILE" stack is not empty and elemnt at index (i%n) is greater than 
        //the stack top, if yes remove the stack top and update the result array at index equal to stack top with value at index(i%n)
//3. Push the index in the stack if i<n(only for the first n traversal), as you don't want to calculate the next greater element for 
        //an element twice (You only traverse twice to see if the element in the array can be the next greater element of the 
        //stack top element) (as we have to consider the input array as circular)

// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //result array
        int[] result = new int[nums.length];
        //edge case
        if(nums == null || nums.length == 0) return result;
        //add -1's to the result
        Arrays.fill(result, -1);
        //array length
        int n = nums.length;
        //create a stack to push all the numbers who's next greater element we have to find
        Stack<Integer> st = new Stack<>();
        //push the first index to start the search from
        st.push(0);
        
        //iterate over the nums array 2 times(circular array) to find the next greater element for the number at stack top
        for(int i=0; i<2*n ; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}