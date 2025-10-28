// Time complexity- O(n)
// Space complexity- O(n)
function nextGreaterElements(nums: number[]): number[] {
	const n = nums.length;
	// initialize result with -1 if element is not found
	const result = new Array(n).fill(-1);

	// to store the indices of elements waiting for a greater element
	const stack = [];

	// loop through the array twice (to do a second pass since we have to look in circular manner)
	for (let i = 0; i < 2 * n; i++) {
		// use i % n to access the current element in the circular array
		// if the current element is greater than the element at the index on top of the stack, update the next greater element for the popped index
		while (
			stack.length > 0 &&
			nums[i % n] > nums[stack[stack.length - 1]]
		) {
			const previousIndex = stack.pop()!;
			result[previousIndex] = nums[i % n];
		}

		// only push indices during the first pass
		if (i < n) {
			stack.push(i);
		}
	}

	return result;
}
