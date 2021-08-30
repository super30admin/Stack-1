class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        tmp=nums[:-1]
        lastInd=len(nums)-1
        ans=[-1]*len(nums)
        nums.extend(tmp)
        stk=[]
        for i in range(len(nums)-1,-1,-1):
            while stk and nums[i]>=stk[0]:
                stk.pop(0)
            if i<=lastInd and stk:
                ans[i]=stk[0]
            stk.insert(0,nums[i])
        return ans