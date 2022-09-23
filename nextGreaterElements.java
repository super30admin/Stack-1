//TC - O(n);
//SC - O(n);
//LC - 503
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i]=-1;
        }
        
        for(int i=0;i<2*len;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%len]){
                int curr = st.pop();
                res[curr] = nums[i%len];
            }
            if(i<len) st.push(i);
            if(i>len && i%len> st.peek()) break;
            
        }
        
        return res;
    }
}
