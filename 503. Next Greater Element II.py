'''
T = O(2n)
S = O(n)

Approach:
Iterate throught the array and store the index of the array elements in a stack,
At each iteration check if the top value of the stack can be poped perform this action untill all the possible values
Find the difference of the such possibilities using the indecies will give the result
'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return nums
        
        stack = []
        res = [-1] * len(nums)
        for i in range(0,2*len(nums)):
            while stack and nums[i % len(nums)] > nums[stack[-1]]:
                idx = stack.pop()
                res[idx] = nums[i % len(nums)] 
            if i < len(nums):
                stack.append(i)
        return res