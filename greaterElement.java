// TC:O(n), sc:O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack <Integer> st = new Stack<>();
        int n = nums.length;
        int [] result = new int[n];
        Arrays.fill(result,-1);
        for(int i=0;i<2*n;i++){
            int idx = i%n;
            while(!st.isEmpty()&&nums[idx]>nums[st.peek()]){
                int popped = st.pop();
                result[popped] = nums[idx];
            }
            if(i<n){
            st.push(idx);
            }
        }
        return result;
    }
}