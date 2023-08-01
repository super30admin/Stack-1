# Time complexity - O(n), n length of array.
#  Space complexity - O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        res=[-1]*n
        st=[]
        for i in range(0,2*n):
            while(len(st)>0 and nums[i%n]>nums[st[-1]]):
                popped=st.pop()
                res[popped]=nums[i%n]
            if(i<n):
                st.append(i)
        return res
