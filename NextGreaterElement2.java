// idea: 
// a) As we iterate through the array, we push the element's index onto a stack 
// b) meanwhile we check whether the array element is greater than last pushed element on to the stack
// c) When we find the array element is greater than the last pushed element, we pop out the element, 
// d) The next high temperature of the popped element is the difference between the element's index and the current element's index in array iteration
// e) we repeat the iteration until we find there is no element in stack whose temperature is less than the current element.
// Time complexity: o(n)
// space complexity: o(n)

// did it run on leetcode: yes

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(res, -1);
        for(int i=0;i<nums.length*2;i++) {
            int temp = nums[i% nums.length];
            while(!stack.isEmpty() && temp > nums[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = temp;
            }
            if(i<nums.length) stack.push(i);
        }
        return res;
        
    }
}