// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Daily temperatures
// Your code here along with comments explaining your approach


class Solution {
    public int[] dailyTemperatures(int[] temp) {
        //We can use stack for comparing the current element with the prev incase if we find and element greater than in the stack we can pop and return to the output array
        Stack<Integer> st = new Stack<Integer>();
        //output array
        int[] res = new int[temp.length];
        for (int i = 0; i< temp.length; i++) {
            //temp[st.pop()] because otherwise as it is storing the index in the stack it will be always be less than the temp array it is getting compared.
            while(!st.isEmpty() && temp[i]>temp[st.peek()]) {
                int idx = st.pop();//st.pop() would give index of the element we are pushing into the stack
                res[idx] = i - idx;// difference of i which the ele we are iterating in the loop and idx is the index of the element in the stack we are pushing
                
            }
            st.push(i);
            
        }
        return res;
        
    }
}


//Next greater element 2
//time complexity: O(N)
//Space complexity: o(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] answer = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = 2*nums.length - 1; i >= 0; i--) {
            // Here we take 2 * length - 1 as we need to look the cycle too
            while(!stack.empty() && nums[i % nums.length] >= nums[stack.peek()])
                stack.pop();
            if (!stack.empty())
                answer[i % nums.length] = nums[stack.peek()];
            else
                answer[i % nums.length] = -1;
            stack.push(i % nums.length);
        }
        return answer;
    }
}
