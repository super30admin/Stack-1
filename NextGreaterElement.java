//o(n) time and space
//passed all leetcode cases
//used monotonic stack approach

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null || nums.length ==0) return new int[]{};
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!stack.isEmpty()&&nums[i%n]>nums[stack.peek()]){
                int prior = stack.pop();
                result[prior] = nums[i%n];
            }

            if(i<n)stack.push(i);
        }
        return result;
    }
}