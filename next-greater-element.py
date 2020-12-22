# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Initialize result array with -1
        n = len(nums)
        result = [-1 for _ in range(len(nums))]

        # Initialize empty stack
        stack = []

        # Traverse over the array 2*- circular array
        for i in range(n*2):
            # If the current number is > the number on top of the stack, this is the next greater number
            # Update the result with the number at the corresponding index(stack.pop() gives this index)
            while stack and nums[i % n] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx] = nums[i % n]

            # Push numbers on the stack only if the next greater element is not found
            if result[i % n] == -1:
                stack.append(i % n)

        return result
