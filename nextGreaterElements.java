/*
TC : O(n)
SC :O (n)
initially, we fill the array with -1;
Then for each element in array, we check if curr num is greater than top value of stack.
if yes, pop from stack and to that index we assign curr num in result array. 
we have to i % n since its circular array
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[]result = new int[nums.length];
        if(nums.length == 0)return result;
        
        
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result,-1);
        //ierate the nums array 
        int n = nums.length;
        for(int i = 0; i < 2*n ;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                int index = stack.pop();
                result[index] = nums[i % n];
            } 
            if(i < n){
                stack.push(i);
            }
            
        }
        return result;
        
    }
}
