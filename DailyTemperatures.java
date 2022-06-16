//time - O(n), space - O(n)
class Solution {
    public int[] dailyTemperatures(int[] nums) {
        if(nums==null || nums.length==0) return null;
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                result[index] = i-index;
            }
            stack.push(i);
        }

        return result;
    }
}
