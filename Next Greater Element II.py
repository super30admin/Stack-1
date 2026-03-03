class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        stack=[]
        result = [-1] * len(nums)

        for i in range(0,2*len(nums)):
            while len(stack)>0 and nums[i%n]>nums[stack[-1]]:
                res=stack.pop()
                result[res]=nums[i%n]
            stack.append(i%n)
        return result
        