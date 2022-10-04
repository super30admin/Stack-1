//TC : O(2n)
//SC : O(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return null;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<2*n;i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                int tmp = stack.pop();
                result[tmp] = nums[i%n];
            }
            if(i<n)
                stack.push(i);
        }
        return result;
    }
}
