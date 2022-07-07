#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
         
        result = [-1]* len(nums)
        stack = []
        n = len(nums)
        for i in range(2*n):
            while stack and nums[i%n] > nums[stack[-1]]:
                curr = stack.pop()
                result[curr] = nums[i%n]
            if i<n:
                stack.append(i)
                
            
            
        return result
                    
        