/*
    Time Complexity - O(n)
    Space Complexity - O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] output = new int[n];
        Arrays.fill(output, -1);

        for(int i = 0; i < 2 * n; i++) {  
            int curElem = nums[i % n];
            while(!stack.isEmpty() && curElem > nums[stack.peek()]){
                int index = stack.pop();
                output[index] = curElem;
            }
            if(i < n) stack.push(i); 
        }
        return output;
    }
}
