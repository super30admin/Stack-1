## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)
# Time Complexity: O(n)
#   - We loop through the array of size 'n' twice (2 * n iterations).
#   - Each index is pushed to the stack at most once and popped at most once.
#   - Therefore, the inner while loop runs at most O(n) times in total across all iterations.
#   - Total Time: O(n).

# Space Complexity: O(n)
#   - The stack can store up to 'n' elements in the worst case (e.g., strictly decreasing array).
#   - The output list 'res' takes O(n) space.
#   - Total Auxiliary Space: O(n).


class Solution:

    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # Initialize result list with -1 for all elements.
        # If no greater element is found, it defaults to -1.
        res = [-1] * n

        # Monotonic stack to keep track of indices of elements
        # whose next greater element hasn't been found yet.
        stack = []

        # Loop through the array twice (2 * n) to simulate circular array behavior.
        for i in range(2 * n):
            # Use i % n to wrap around to the beginning of the array.
            curr_val = nums[i % n]

            # While stack is not empty and current element is greater than
            # the element at the index stored at the top of the stack:
            while stack and curr_val > nums[stack[-1]]:
                # Pop index from stack and record curr_val as its next greater element.
                prev_index = stack.pop()
                res[prev_index] = curr_val

            # Only push indices from the first pass (0 to n - 1) onto the stack.
            # The second pass is only used to resolve next greater elements for remaining indices.
            if i < n:
                stack.append(i)

        return res