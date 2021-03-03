//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums.length == 0 || nums == null)return result;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(result,-1);
        int n = nums.length;
        for(int i =0;i<n*2;i++){
            while(!st.isEmpty() && nums[i%n]>nums[st.peek()]){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}