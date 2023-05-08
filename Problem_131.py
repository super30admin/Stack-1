# TC : O(N)
# SC : O(N)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        list1 = [0] * n
        st = []
        st.append(0)
        c = 0
        for i in range(1, n):
            while st and temperatures[st[-1]] < temperatures[i]:
                val = st.pop()
                list1[val] = i - val
            st.append(i)
            
        return list1