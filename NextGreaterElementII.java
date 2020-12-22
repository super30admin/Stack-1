/**
 * SC : O(n) TC : O(n)
 * Approach: As we can go back to the sstart of the array, Start pushing elements for the first trraverse and then for second traversal
 *           fill the result array.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res,-1);
        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int idx = st.pop();
                res[idx] = nums[i%n];
            }
            if(i < n){
                st.push(i);
            }
        }
        return res;
    }
}
