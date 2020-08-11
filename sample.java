// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int result[] = new int[T.length]; // to store result
        Stack<Integer> st = new Stack<>(); // to keep unresolved indices
        for(int i=0; i<T.length; i++) // iterate over the temp array
       {
            while(!st.isEmpty() && T[i]>T[st.peek()]) // till the stack is not empty and we can resolve the index to get a warmer day
            {
                int index = st.pop(); // pop the index
                result[index] = i- index; // store when we get the next warmer day
            }
           st.push(i); // put the index in stack to be resolved
       }
        return result;
    }
}

// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //edge case
        if(nums==null || nums.length == 0)
            return nums;
        int n = nums.length;
        int result [] = new int[n];
        Arrays.fill(result, -1); // as if next greater element not present we need to store -1
        Stack<Integer> st = new Stack<>();
       
        for(int i=0;i<2*n;i++) // circular array
        {
           while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) // till stack is not empty and we have a next greater element for the index at stack peek
           {
                 int index = st.pop(); // get the index
                 result[index] = nums[i%n]; // store the greater value in result at that index
           }
             
            if(i<n) // push only once not for the second round
                st.push(i);
        }
        return result;
    }
}