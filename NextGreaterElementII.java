// Time Complexity: O(n) -> n is the number of elements in the input array
// Space Complexity: O(n) -> n - size of the stack


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return new int[0];
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result , -1);
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < 2*n ; i++){  // as the array is circular, we require 2 iterations

            while(!st.isEmpty() && nums[i%n] > nums[st.peek()] ){
                int idx = st.pop();
                result[idx] = nums[i%n];
            }

            if(i < n){
               st.push(i); // we'll just push the elements to stack in the first cycle
            }

        }
        return result;
    }
}
