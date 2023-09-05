# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        st=deque()
        n=len(nums)
        result=[-1 for i in range(n)]
        for i in range(2*n):
            while(len(st) and nums[st[-1]]<nums[i%n]):
                popped=st.pop()
                result[popped]=nums[i%n]
            if(i<n):
                st.append(i)
        return result