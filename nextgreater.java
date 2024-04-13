// TC = O(n)
// SC = O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] r = new int[n];
        Arrays.fill(r, -1);
        for(int i=0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int popped = st.pop();
                r[popped] = nums[i%n];
            }
            if(i<n){
                st.push(i);
            }
        }
        return r;
    }
}