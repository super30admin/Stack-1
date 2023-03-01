#time O(N)
#space O(N)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # nums1=nums
        # nums=nums+nums
        # l=[]
        # d={}
        # result=[-1]*(len(nums)//2)
        # for i in nums:
        #     while l and l[-1]<i:
        #         d[l[-1]]=i
        #         l.pop()
        #     l.append(i)
        # # print(d)
        # for j,i in enumerate(nums1):
        #     if i in d:
        #         result[j]=d[i]
        # return result
        stack = []
        n = len(nums)
        ans = [-1] * n
        for i in range(2*n):
            while stack and nums[stack[-1]] < nums[i % n]:
                ans[stack[-1]] = nums[i % n]
                stack.pop()
            if i < len(nums):
                stack.append(i)
        return ans  