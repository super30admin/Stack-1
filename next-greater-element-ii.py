class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # tc O(n), sc O(n).
        monotonous_stack = []
        res = [-1]*len(nums)
        for idx in range(2*len(nums)-1, -1, -1):
            i = idx % len(nums)
            while monotonous_stack and monotonous_stack[-1] <= nums[i]:
                monotonous_stack.pop()
            
            if monotonous_stack:
                res[i] = monotonous_stack[-1]
            monotonous_stack.append(nums[i])
        
        return res
