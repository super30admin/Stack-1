#Time Complexity : O(N)
#Space Complexity: O(N)
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        stack = []
        res = [-1] * n
        for i in range(0, 2 * n):
            while len(stack) > 0 and nums[i % n] > nums[stack[-1]]:
                popped_index = stack.pop()
                res[popped_index] = nums[i % n]
            if i < n:
                stack.append(i)
        return res
            
            






        