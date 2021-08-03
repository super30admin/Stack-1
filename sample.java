//https://leetcode.com/problems/daily-temperatures/
//Time Complexity = O(2n)
//Space Complexity = O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0) return result;
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0; i < temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int top = st.pop();
                result[top] = i - top; 
            }
            st.push(i);
        }
        return result;
    }
}

//https://leetcode.com/problems/next-greater-element-ii/
//Time Complexity = O(3n)
//Space Complexity = O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        if(nums == null || nums.length == 0) return result;
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int top = st.pop(); 
                result[top] = nums[i % n];
            }
            if(i < n) st.push(i);
        }
        return result;
    }
}
