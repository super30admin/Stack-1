//503. Next Greater Element II
//Time Complexity: O(n)
//Space Complexity:O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int [] result = new int[n];
        Arrays.fill(result,-1);
        for(int i =0; i<2*n;i++){
            int idx = i%n;
            while(!st.isEmpty() && nums[idx] > nums[st.peek()]){
                int poppedIdx = st.pop();
                result[poppedIdx] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return result;
    }
}