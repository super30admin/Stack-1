# https://leetcode.com/problems/next-greater-element-ii/

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        res = [-1] * n

        for i in range( 2 * n):# for circular
            while stack and nums[stack[-1]] < nums[i % n]:
                index = stack.pop()
                res[index] = nums[i%n]
            
            if i < n: # we are putting those indexex into stack only once
            # when we are going again we won't this check is for that
                stack.append(i)
            
        return res

# monotonic stack
# TC: O(n)
# SC: O(n)
        