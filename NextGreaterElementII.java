public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) return null;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
            for(int i=0;i<2*n;i++){
                while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                int curr = st.pop();
                res[curr] = nums[i%n];
            }
           if(i<n) st.push(i);
           if(i>=n && st.peek()==i%n) break;
        }
        return res;
    }
}

// Time Complexity - O(4n) = O(n)
// Space Complexity - O(n)
