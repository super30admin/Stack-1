Problem 1 Daily Temp
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
// for any given temperature, put all temperatures which are smaller in stack until u find a bigger temp than current one. when u find a greater one, resolve all top elements from stck
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null || temperatures.length==0) return new int[0];
        int[] res=new int[temperatures.length];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() &&  temperatures[st.peek()]<temperatures[i]){
                int popped=st.pop();
                res[popped]=i-popped;
            }
            st.push(i);
        }
        return res;
    }
}

Problem 2 Next greater Elements
// Time Complexity : O(3n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
// in circular manner-> check for next greater elements all the time. at max, we will visit any idex 2 times. so run i from 0 to 2n
//put smaller elements in stack and once u find a bigger element, resolve all stack.top elements.
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];

        int[] res=new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<2*nums.length;i++){
            if(i>nums.length){ //in second iteration
                if(st.peek()==i%nums.length)
                    break;
            }
            while(!st.isEmpty() && nums[st.peek()]<nums[i%nums.length]){
                int popped= st.pop();
                res[popped]=nums[i%nums.length];
            }
            if(i<nums.length)
                st.push(i);
        }
        return res;
    }
}