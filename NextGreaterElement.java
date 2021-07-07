// Time - O(n)
// Space - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i=0;i<2*n; i++){ 
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = nums[i%n];
            }
            if(i < n)
                stack.push(i%n);    
            
        }
        return result;
    }
}
