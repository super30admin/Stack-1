#Time: O(2n) = O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        if temperatures is None or len(temperatures) == 0:
            return 0
        
        result = [0] * len(temperatures)
        st = []
        
        for i in range(len(temperatures)):
            while(st and temperatures[i] > temperatures[st[-1]]):
                popIx = st.pop()
                result[popIx] = i - popIx
            st.append(i)
        
        return result
        
        