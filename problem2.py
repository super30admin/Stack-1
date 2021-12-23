# 503 next greater element 2
# time - o(n)
# space - o(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        stack = []
        result = [-1]*len(nums)
        n = len(nums)
        for i in range(len(nums)*2):
            
            while(len(stack) and nums[stack[-1]] < nums[i % n]):
                
                poppedIndex = stack.pop()
                result[poppedIndex] = nums[i % n]
            
            if i < len(nums):
                
                stack.append(i)
            
                    
        return result