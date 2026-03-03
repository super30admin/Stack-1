   /**
    Time Complexity : O(N)
    Explanation:
    We loop 2*N times to simulate circular array.
    Each index is pushed once (only when i < N) and popped at most once.
    So total stack operations are linear.

    Space Complexity : O(N)
    Explanation:
    Stack can store up to N indices and result array is size N.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially didn’t know how to handle the circular nature of the array.
    Fixed it by looping from 0 to 2*N and using (i % N) to wrap around.
    Also made sure to push indices only during the first pass (i < N)
    to avoid duplicates in the stack.
    */
    class Solution {

 

        public int[] nextGreaterElements(int[] nums) {
    
            int n = nums.length;
            Stack<Integer> st = new Stack<>();
            int[] res = new int[n];
    
            // Initialize result with -1 (default if no next greater exists)
            for (int i = 0; i < n; i++) {
                res[i] = -1;
            }
    
            // Traverse twice to simulate circular array
            for (int i = 0; i < 2 * n; i++) {
    
                while (!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                    int idx = st.pop();
                    res[idx] = nums[i % n];
                  
                }
    
                // Push only in first pass
                if (i < n) {
                    st.push(i);
                }
            }
    
            return res;
        }
    }