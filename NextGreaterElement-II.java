//time o(n)
//space o(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<2*len; i++) {
            int idx = i%len;
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                res[stack.pop()] = nums[idx];
            }
            if(i<len) {
                stack.push(idx);
            }
        }
        
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
}