# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        if n == 1:
            return [0]

        result = [0] * n
        st = []
        st.append(0)
        
        for i in range(1, n):
            while st and temperatures[i] > temperatures[st[-1]]:
                prev_idx = st.pop()
                result[prev_idx] = i - prev_idx
            st.append(i)

        return result
