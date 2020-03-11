//TC : o(n) , length of nums array
//SC : O(n) , stack space
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        int n = nums.length;
        
        for(int i=0;i<2*n;i++){
            
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
                int idx = st.pop();
                result[idx] = nums[i%n];
                
            }
            if(i<n)
                st.push(i%n);
        }
        
        return result;
        
    }
}