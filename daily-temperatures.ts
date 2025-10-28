// Time complexity- O(n)
// Space complexity- O(n)
function dailyTemperatures(temperatures: number[]): number[] {
	const n = temperatures.length;
	const result = new Array(n).fill(0);
	// to stores indices of waiting days to calculate warmer days
	const stack = [];

	for (let i = 0; i < n; i++) {
		// calculate the waiting days until the current temperature is warmer than the temperature at the index on top of the stack
		while (
			stack.length > 0 &&
			temperatures[i] > temperatures[stack[stack.length - 1]]
		) {
			const previousIndex = stack.pop()!;

			// calculate waiting days and update result array
			result[previousIndex] = i - previousIndex;
		}

		// add current idex to waiting stack
		stack.push(i);
	}

	return result;
}
