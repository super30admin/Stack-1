## T(c) : O(n)... asymptotic
## S(c) : o(n)... Size of maintaining the stack

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        arr = [-1] * len(nums)
        stack = []
        stack.append([nums[0], 0])
        for i in range(1, 2 * len(nums)):
            idx = i % len(nums)
            while stack and nums[idx] > stack[-1][0]:    
                value, index = stack.pop()
                arr[index] = nums[idx]
            
            if i < len(nums):
                stack.append( [nums[idx], idx])
        
        return arr

        
