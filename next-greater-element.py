class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums is None or len(nums) == 0:
            return []
        n = len(nums)
        res = [-1]*n
        stack = []
        for i in range(2*n):
            while(len(stack) > 0 and nums[i % n] > nums[stack[-1]]):
                idx = stack.pop()
                res[idx] = nums[i % n]
            if(i < n):
                stack.append(i)
        return res
