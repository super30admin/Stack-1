// Time, Space - O(N),O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        
        int[] result = new int[nums.length];
        
        Arrays.fill(result,-1);
        int n = nums.length;
        for(int i=0;i<2*n;i++) {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                result[st.pop()] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        
        
        return result;
    }
}
