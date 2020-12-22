// Time Complexity : o(3n) , Bruteforce - O(n^2)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
// Leetcode : 503
//Approach: Stack


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return new int[0]; 
        int res[] = new int[nums.length];
        Arrays.fill(res,-1);
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        //Result array
        for(int i = 0 ; i < 2*n; i++){
            while(!st.isEmpty() && nums[i%n] > nums[st.peek()]){
                int index = st.pop();
                res[index] = nums[i%n];
            }if(i < n){
                st.push(i%n);      
            }   
        }
        return res;
     }
    
}