
import java.util.Arrays;
import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            }
            st.push(i);
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach

class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        boolean flag = true;
        for(int i=0; i< 2*n; i++) {
            if(flag = false) break;
            while(!flag && !st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                result[st.pop()] =nums[i%n];
                if(i > n-1 && i %n == st.peek()) {
                    flag = false;
                }
            }
            if(i < nums.length)
                st.push(i);
        }
        return result;
    }
}