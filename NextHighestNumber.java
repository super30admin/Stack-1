TC:O(n) - traverse 2 times. n no.of elements in an array.
SC:O(n) - for stack
Successfully run on leetcode



class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] result = new int[nums.length];
        int n=nums.length;
        Arrays.fill(result,-1);
        Stack<Integer>st = new Stack<>();//stack to store the indices
        for(int i=0;i<2*n;i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int cur = st.pop();
                result[cur] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
            
        }
        return result;
        
    }
}