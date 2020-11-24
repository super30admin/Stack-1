# Leetcode: https://leetcode.com/problems/next-greater-element-ii/

"""
Approach: Using Stack, store the index in decreasing order of the nums[index] values.
Iterate through the nums array 2*N times, to populate all the values in output as circular array.

Time Complexity: O(N), Only two traversals of the nums array are done. Further, atmost 2n elements are pushed and popped from the stack.
Space Complexity: O(N). A stack of size n is used. output array of size n is used.
"""


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []

        l = len(nums)
        output = [-1] * l
        stack = []

        for i in range(2 * l):
            x = i % l

            while stack and nums[stack[-1]] < nums[x]:
                top = stack.pop()
                output[top] = nums[x]

            if output[x] == -1:
                stack.append(x)

        return output