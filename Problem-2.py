'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1 for _ in range(n)]
        stack = []

        for i in range(n):
            while len(stack) and stack[-1][0] < nums[i]:
                idx = stack[-1][1]
                result[idx] = nums[i]
                stack.pop()

            stack.append((nums[i], i))

        for i in range(n):
            while len(stack) and stack[-1][0] < nums[i]:
                idx = stack[-1][1]
                result[idx] = nums[i]
                stack.pop()

        return result