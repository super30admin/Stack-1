#Time complexity : O(N)
#Space complexity : O(N) 
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1]*n
        stack = []
        stack.append(0)
        for index in range(1,2*n):
            item = nums[index%n]
            while(stack and item>nums[stack[-1]]):
                result[stack.pop()] = item
            if index<n:
                stack.append(index%n)
        
        return result