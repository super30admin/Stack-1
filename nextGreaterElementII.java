// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
  public int[] nextGreaterElements(int[] nums) {
    if(nums == null || nums.length == 0) return new int[]{};
    int n = nums.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    Arrays.fill(result, -1);
    for(int i = 0; i<2*n; i++) {
      while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) {
        int popped = stack.pop();
        result[popped] = nums[i%n];
      }
      if(!stack.isEmpty() && stack.peek()==i%n) break;
      if(i<n) stack.push(i);
    }
    return result;
  }
}