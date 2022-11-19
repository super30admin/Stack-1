package Stack-1;

public class problem2 {
    class Solution {
        //TC:- O(3n) == O(n)
        //SC:- O(n)
        public int[] nextGreaterElements(int[] nums) {
            if(nums == null || nums.length == 0) return new int[] {};
            
            int n = nums.length;
            Stack<Integer> st = new Stack<>();
            int[] result = new int[nums.length];
            Arrays.fill(result, -1);
            
            
            for(int i = 0; i < 2 * n; i++){
                while(!st.isEmpty() && nums[i % n] > nums[st.peek()]){
                    int index = st.pop();
                    result[index] = nums[i % n];
                }
                if(i < n){
                    st.push(i);
                }
            }
            
            return result;
        }
    }
}
