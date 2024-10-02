// time complexity = O(4*n) = O(n)
// space complexity = O(n)// the result array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Monotonically decreasing stack
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);// fill this with -1, since the last element in the stack. the greatest element is not going to have anyone else apart from itself. As per the problem, it needs to be -1.
        int n = nums.length;
        // why 2 times- since we do a second pass to determine for the elments who is greater.
        for(int i=0;i< 2*n;i++) {
            while(!stack.isEmpty() && nums[i%n]> nums[stack.peek()]) {
                int popped = stack.pop();
                res[popped] = nums[i%n];// assign the value.
            }
            // do not put the repeated elements during the second pass.
            if(i<n) {
                stack.push(i);
            }            
        }
        return res;
    }
}