/*
Approach
Check if the curr number < next ie resolving then place their difference in resultant array.
If not keep adding to stack

Executed on leetcode
Time complexity: O(3n)  circularly visited over the array + while resolving also visiting the stack 
Space complexity : O(n) stack space
*/

class Solution {
  
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0 ) return new int[0];
        
        int n = nums.length;
          int[] result = new int[n];
        
        Arrays.fill(result,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < 2*n ; i++){  //circular     //O(2n)
         //if resolved  able to find even if revisiting same array again 
            // find next greater 
                while(!st.isEmpty() &&  nums[i%n] > nums[st.peek()]){  //O(n)
                    int index = st.pop();
                    result[index] = nums[i%n];
                }
            //we dont want to push again in the stack for second round circular
            if(i < n){
              st.push(i%n); // not resolved then push on stack 
            }
        }
        return result;
    }
}