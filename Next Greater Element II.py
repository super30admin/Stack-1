class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        n = len(nums) 
        result = [-1 for i in range(n)]   
        stack = []

        for i in range(2*n):

            while stack and nums[stack[-1]] < nums[i % n]:
                popped = stack.pop()
                result[popped] = nums[i % n]

            if i < n:
                stack.append(i)

        return result