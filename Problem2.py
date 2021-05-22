
## Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums)==0:
            return []
        n = len(nums)
        result = [-1 for x in range(n)]
        stack = []
        for i in range(2*n):
            while len(stack)!=0 and nums[i%n] > nums[stack[-1]]:
                idx = stack.pop()
                result[idx]= nums[i%n]
            if i<n:
                stack.append(i)
        return result
#Time Complexity: O(n)
#Space Complexity: O(n)
#Approach: stack
