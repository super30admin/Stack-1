// Time Complexity : O(4n) ~ O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); //O(n)

        for(int i = 0; i < 2*n; i++) { //O(3n)
            while(!st.isEmpty() && nums[st.peek()] < nums[i%n]) {
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            if(i < n)
                st.push(i%n);
            else 
            if(st.peek() == i%n) break;
        }
        return result;
    }
}