//TIme Complexity : O(n) n is the numberof elements in T
//Space Complexity : O(n) since I'm using stack
// LeetCode : passed all tests.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result  = new int[nums.length];
        if(nums == null || nums.length == 0) return result;
        int n = nums.length;
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i <2*n ; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                result[st.pop()] = nums[i%n];
            }
            
            st.push(i%n);
        }
        
        return result;
        
    }
}