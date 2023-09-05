#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st=[]
        result=[0]*(len(temperatures))
        for i in range(len(temperatures)):
            while st and temperatures[st[-1]]<temperatures[i]:
                popped=st.pop()
                result[popped]=i-popped
            st.append(i)
        return result
        