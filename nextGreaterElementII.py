class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack=[0]
        res=[-1]*len(nums)

        for idx, value in enumerate(nums):
            if idx==0:
                continue
            
            while stack and value>nums[stack[-1]]:
                popped=stack.pop()
                res[popped]=value
            
            stack.append(idx)
        

        for value in nums:
            while stack and value>nums[stack[-1]]:
                popped=stack.pop()
                res[popped]=value
        

        return res