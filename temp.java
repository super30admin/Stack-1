// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
    }

