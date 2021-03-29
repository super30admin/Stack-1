//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        
        int[] ans= new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums.length*2;i++){
            int index=i%nums.length;
            
            while(!st.isEmpty() && nums[st.peek()]<nums[index]){//finding hte next greater value and adding intermediate values in the stack
                int popped=st.pop();    
                ans[popped]= nums[index];
            }
            if(ans[index]==-1)//adding to stack only when -1 is the value
                st.push(index);
        }
        
        return ans;
    }
}