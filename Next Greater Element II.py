import numpy as np
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        res = np.empty(n, dtype=int)
        res.fill(-1)

        # Store (index, num) in stack and pop if a larger number is found
        stack.append((0, nums[0]))
        for i in range(1, n):
            while stack and stack[-1][1] < nums[i]:
                index, num = stack.pop()
                res[index] = nums[i]
            stack.append((i, nums[i]))
        
        # Checking again for elements in stack as it is a circular array
        if stack:
            for i in range(0, n):
                while stack and stack[-1][1] < nums[i]:
                    index, num = stack.pop()
                    res[index] = nums[i]
            
        return res
