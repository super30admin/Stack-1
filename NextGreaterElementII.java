// TC = O(N)
//SC = O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int curr = st.pop();
                res[curr] = nums[i%n];
            }
            if(i < n){  // no need to push element in stack after one iteration
                st.push(i);
            }
            
            if(i>=n && st.peek() == i%n) break;   //reached the greatest element after updating all other elements. No need to go further.
            
        }
        return res;
    }
}
