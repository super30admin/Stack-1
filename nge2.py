class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        size = len(nums)
        nums+=nums
        res = [-1] * size
        stack = []
        for i in list(range(size))*2:
            while stack and (nums[stack[-1]] < nums[i]):
                res[stack.pop()] = nums[i]
            stack.append(i)
        return res
        
        
        #tc and sc = o(n) 
