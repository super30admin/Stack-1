//time - O(n), space - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length==0) return null;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int i=0; i<2*n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                int index = stack.pop();
                result[index] = nums[i%n];
            }
            if(i < n)
                stack.push(i);
        }

        return result;
    }
}
