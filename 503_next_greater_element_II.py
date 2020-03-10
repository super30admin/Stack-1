from typing import List


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """
            https://leetcode.com/problems/next-greater-element-ii/
            Time Complexity - O(n)
            Space Complexity - O(n)
        """
        if not nums:
            return []
        n = len(nums)
        result = [-1] * n
        pending_stack = []
        for i in range(2 * n):
            while pending_stack and nums[i % n] > nums[pending_stack[-1]]:
                prev_idx = pending_stack.pop()
                result[prev_idx] = nums[i % n]
            if i < n:
                pending_stack.append(i)
        return result


if __name__ == '__main__':
    print(Solution().nextGreaterElements([5, 4, 3, 2, 1]))
