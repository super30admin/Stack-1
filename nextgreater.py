#Time Complexity : O(n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1]*len(nums)
        st = deque()
        for i in range(2*len(nums)):
            j = i%len(nums)
            while len(st)!=0 and nums[j]>nums[st[-1]]:
                temp = st.pop()
                res[temp] = nums[j]
            st.append(j)
        return res