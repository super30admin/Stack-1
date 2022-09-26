#time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n= len(nums)
        result = [-1] * n
        stack = nums[::-1]
        if (nums == None or len(nums) == 0):
            return result
        for i in range(n-1, -1, -1):
            while stack and stack[-1] <= nums[i]:
                stack.pop()
                
                
            if stack:
                result[i] = stack[-1]
            stack.append(nums[i])
                
        return result
