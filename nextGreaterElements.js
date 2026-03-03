/**
 * @param {number[]} nums
 * @return {number[]}
 Intuition:
 This uses a 'monotonic decreasing stack' to keep indices of elements whose next greater element hasn't been found yet.
 We iterate twice (2 * n) to simulate a circular array, using 'i % numsLength' to wrap around.
 Whenever the current number is greater than the top index in the stack, we pop and update its result — ensuring each element is processed efficiently in 'O(n)' time.
 T.C: O(n)
 S.C: O(n)
 */
var nextGreaterElements = function (nums) {
    let numsLength = nums.length;
    let result = Array.from({
        length: numsLength
    }).fill(-1);
    let stack = []
    for (let i = 0; i < 2 * numsLength; i++) {
        let idx = i % numsLength;
        while (stack.length > 0 && nums[idx] > nums[stack[stack.length - 1]]) {
            let popped = stack.pop();
            result[popped] = nums[idx];
        }
        if (result[idx] === -1) {
            stack.push(idx);
        }
    }
    return result;
};