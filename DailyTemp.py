#Time Complexity : O(n)
#Space Complexity :O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures == None or len(temperatures) == 0:
            return 0
        st = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while len(st) != 0 and temperatures[st[-1]] < temperatures[i]:
                x = st.pop()
                result[x] = i - x
            st.append(i)
        return result
