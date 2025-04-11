#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]: 
        n = len(nums)
        result = [-1] * n
        stack = []
        for i in range(0,2*n):
            while stack and nums[stack[-1]]<nums[i%n]:
                result[stack.pop()] = nums[i%n]       
            if(i<n):
                stack.append(i%n)
        return result