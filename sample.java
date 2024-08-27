// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//next greater element
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!s.isEmpty() && nums[i % n] > nums[s.peek()]) {
                int popped = s.pop();
                res[popped] = nums[i % n];
            }
            if (!s.isEmpty() && i % n == s.peek()) { 
                break;
            }
            if (i < n) {
                s.push(i);
            }
        }

        return res;
        
    }
}

//Daily temperatures

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()] ) {
                int popped = st.pop();
                res[popped] = i - popped;
            }
            st.push(i);
        }
        return res;
    }
        
}
