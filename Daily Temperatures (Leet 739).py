'''
Using Monotonic Stack
Time: O(2n) -> O(n) (max each element is touched twice)
Space: O(n)
'''

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        if temperatures is None or len(temperatures) == 0:
            return None
        
        res = [0 for _ in range(len(temperatures))]
        st = list()
        
        for i in range(len(temperatures)):
            
            while len(st) > 0 and temperatures[st[-1]] < temperatures[i]:
                curr = st.pop()
                res[curr] = i - curr
            
            st.append(i)
        
        return res