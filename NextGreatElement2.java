// TC & SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> st = new Stack<>();
        // 2*n - for circular traversal. Fpr one traversal, n was perfect
        for(int i=0; i<2*n; i++) {
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[i%n];
            }
            // if(i < n) 
            st.push(i%n);
            // else if(st.peek )
        }  

        return result;      
    }
}
