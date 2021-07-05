class Solution {
    public int[] nextGreaterElements(int[] nums) {
	Stack<Integer> s = new Stack<>();
	int n = nums.length;
	int[] ans = new int[n];
	Arrays.fill(ans, -1);
	for (int i = 2 * n - 1; i >= 0; i--) {
		int j = i % n;
		while (!s.isEmpty() && s.peek() <= nums[j]) s.pop();
		if (!s.isEmpty()) ans[j] = s.peek();
		s.push(nums[j]);
	}
	return ans;
}
}
//SC:O(N)
//TC:O(N)
