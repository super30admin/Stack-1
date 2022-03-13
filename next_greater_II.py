# sc and tc : O(N)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        res = [-1] * n 
        
        for i in range(2*len(nums)):
            while stack and nums[stack[-1]] < nums[i%n] :
                popped = stack.pop()
                res[popped] = nums[i%n]
            if i<n:
                stack.append(i)
            
        return res
                
            
