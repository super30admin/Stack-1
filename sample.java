// # Stack-1

// ## Problem1 Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :I didnt face any problem while coding this


// Your code here along with comments explaining your approach

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            while(!st.empty() && temperatures[i]>temperatures[st.peek()]){
            int popped = st.pop();
            result[popped] = i - popped;
        }st.push(i);
        }
        return result; 
    }
}

// ## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :I didnt face any problem while coding this


// Your code here along with comments explaining your approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        for(int i=0; i< 2 * n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}