 """
FAANMG Problem #132 {Medium} 

503. Next Greater Element II

# Time Complexity = O(n)
# Space Complexity = O(n)


Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar
"""

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        
        result = [-1]*n
        stack =[]
        
        # Traverse the array twice to handle circularity
        for i in range(2*n):
            # Pop the stack until a greater element is found or the stack becomes empty
            while stack and nums[i%n] > nums[stack[-1]]:
                j = stack.pop()
                
                result[j] = nums[i%n]
                
            if i < n:
                stack.append(i % n)
                
        return result
        