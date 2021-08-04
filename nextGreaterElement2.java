// Time: O(n)
//Space: O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null) return result;
        
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);
        int n = nums.length;
        
        for(int i=0; i < 2*n;i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int top = st.pop();
                result[top] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return result;
    }
}