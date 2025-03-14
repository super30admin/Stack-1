//Time Complexity - O(n)
//Space Complexity - O(n)
class GreatestElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            while (!s.isEmpty() && nums[index] > nums[s.peek()]) {
                int popped = s.pop();
                result[popped] = nums[index];
            }
            if (i < n) {
                s.push(i);
            }
        }
        return result;
    }
}
