# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1] * len(nums)
        n = len(nums)
        if nums == None:
            return result
        stack = []
        for i in range(2 * len(nums)):
            while stack and nums[i%n] > nums[stack[-1]]:
                top = stack.pop()
                result[top] = nums[i%n]
            if i <n:
                stack.append(i)
        return result