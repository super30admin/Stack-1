# Time Complexity : O(n) worst case O(3n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        result = [-1] * len(nums)
        i = 0
        n = len(nums)
        while i < 2*len(nums): #O(2n)
            while len(stack) > 0 and nums[i%len(nums)] > stack[len(stack)-1][0]: #worst case O(n), so total O(3n)
                lastelement = stack[len(stack)-1]
                result[lastelement[1]] = nums[i%n]
                stack.pop()
            if i < n:
                stack.append((nums[i],i))
            if i > n and i%n == stack[len(stack)-1][1]:
                break
            i += 1

            
        return result