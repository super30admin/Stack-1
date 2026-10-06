// stack problem 
// O(2n) time complexity
//o(n) space complexity

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0 ; i < n; i++){
            result[i] = -1;
        }

        for(int i = 0 ; i < 2 *n ; i++){
             int index = i %n ;
            
          
            while(!st.empty() && nums[index] > nums[st.peek()]){
               
                 int prevIndex = st.pop();
                 result[prevIndex] = nums[index];

            }
            if(i < n){
                st.push(i);
            }
            
        }
        return result;
        
    }
}
