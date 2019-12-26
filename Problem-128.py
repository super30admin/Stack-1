'''
Leet code - 503. Next Greater Element II - https://leetcode.com/problems/next-greater-element-ii/
Time complexity - O(N)
Approach - We are using stack to store the index of the elements, if we find next greater element then we pop it out from the stack and append it to the resultant array.

'''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res=[-1 for i in range(len(nums))]
        stack=[]
        for x in range(2*(len(nums))):
            i=x%len(nums)
            while stack and nums[i]>nums[stack[-1]]:
                index=stack.pop()
                res[index]=nums[i]
            stack.append(i)
        return res
                
        