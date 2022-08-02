#739. Daily Temperatures
"""
Time Compelxity : O(n)
Space Compelxity : O(n) #stack 
"""
class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        st = []
        st.append(0)
        result = [0]*len(temp)
        
        for i in range(1, len(temp)):
            while len(st) != 0 and temp[st[-1]] < temp[i]:
                idx = st.pop()
                result[idx] = i - idx
                
            st.append(i)
            
        return result
