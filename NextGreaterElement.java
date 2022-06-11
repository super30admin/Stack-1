// Time Complexity: O(n) where n is the length of the array.
// Space Complexity: O(n) where n is the length of the array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return new int[] {};
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();   // For storing indices.
        for(int i = 0; i < 2 * n; i++) {    // Circular array takes two passes.
            while(!s.isEmpty() && nums[i % n] > nums[s.peek()]) {   // % n for beginnning indices.
                int top = s.pop();
                answer[top] = nums[i % n];
            }
            if(i < n) {         // Unresolved indices added to stack only in the 1st pass.
                s.push(i);
            }
        }
        return answer;
    }
}