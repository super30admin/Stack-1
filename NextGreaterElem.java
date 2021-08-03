//TC = O(3*n) --> O(n)
//SC = O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int [] result = new int[nums.length];

        
        if(nums == null || nums.length == 0)
            return result;
        
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result, -1);
        
        int n = nums.length;
        
        for(int i=0; i < 2*n; i++) {
            
            while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                int index = st.pop();
                result[index] = nums[i%n];
                
            }
            
            if(i<n) st.push(i);
        }
        
        return result;
        
    }
}