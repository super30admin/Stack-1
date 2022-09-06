"""
Runtime Complexity: O(n) - where 'n' is the length of the given list.
Space Complexity: O(n) - we create a stack and in the worst case, the given temperatures in decreasing order, the stack might endup
holding all the elements of the temperature list.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not temperatures or len(temperatures)==0:
            return []
        if len(temperatures)==1:
            return [0]
        n = len(temperatures)
        st = []
        result = [0 for i in range(n)]
        
        for i in range(0,n):
            while st and temperatures[i]>temperatures[st[len(st)-1]]:
                idx = st.pop()
                result[idx] = i-idx
            st.append(i)
        
        return result
        