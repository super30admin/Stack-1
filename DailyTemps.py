# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Using the resultant array as the monotonic stack'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        t = temperatures
        hott = t[-1]
        res = [0] * len(t)
        
        for i in range(len(t) - 2, -1, -1):
            if t[i] >= hott:
                hott = t[i]
            else:
                j = i + 1
                while t[i] >= t[j]: #globally bounded to N forward seeks, hence, O(N)
                    j += res[j]
                res[i] = j - i
        
        return res
        


# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Explicit Monotonic Stack'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        t = temperatures
        st = []
        res = [0] * len(t)
        
        for i in range(len(t)):
            while st and t[i] > t[st[-1]]:
                j = st.pop()
                res[j] = i - j
            st.append(i)
        
        return res
