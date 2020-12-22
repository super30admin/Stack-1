// Time Complexity : o(3n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class NextGrater {
    public int[] nextGreaterElements(int[] nums) {
        
        if(null == nums || nums.length == 0) return new int[nums.length];
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<Integer>();
        int n = nums.length;
        for(int i = 0; i< 2*n; i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                result[stack.pop()] = nums[i%n];
                
            }
            if(i < n) {
                stack.push(i);
            }
        }
        return result;  
    }
}