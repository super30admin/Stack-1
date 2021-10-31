#Time Complexity : O(n)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0]*len(temperatures)
        st = deque()
        for i in range(len(temperatures)):
            while len(st)!= 0 and temperatures[i]>temperatures[st[-1]]:
                temp = st.pop()
                res[temp] = i - temp
            st.append(i)
        return res
        