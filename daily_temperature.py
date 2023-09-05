# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st=deque()
        
        n=len(temperatures)
        ans=[0 for i in range(n)]
        # curr_temp=(None, None)
        for i in range(n):
            while(len(st) and temperatures[st[-1]]<temperatures[i]):
                popped=st.pop()
                ans[popped]=i-popped
            st.append(i)
        return ans