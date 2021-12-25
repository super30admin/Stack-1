//time o(n)
//space o(n)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<2*n; i++) {
            int index = i%n;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                res[stack.peek()] = nums[index];
                stack.pop();
            }
            if(i<n) {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }
}
