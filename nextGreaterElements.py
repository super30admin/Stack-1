#O(N)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        N = len(nums)
        ans = [-1] * len(nums)
        
        for idx in range(2 * N):
            while stack and nums[stack[-1]%N] < nums[idx%N]:
                i = stack.pop()
                ans[i] = nums[idx % N]
            if idx < N:
                stack.append(idx)
        
        return ans
