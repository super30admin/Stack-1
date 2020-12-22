#Time: O(2n)
#Space: O(N)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        if nums is None or len(nums)==0:
            return []

        n = len(nums)
        stack = []
        res = [-1]*len(nums)
        for i in range(2*n):
            while stack and nums[i%n] > nums[stack[-1]]:
                idx = stack.pop()
                res[idx] = nums[i%n]

            if i < n:
                stack.append(i)


        return res

            
