from typing import List
from collections import deque
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        if temperatures == None or len(temperatures) == 0:
            return result
        st = deque()
        for i in range(len(temperatures)):
            while len(st) > 0 and temperatures[i] > temperatures[st[-1]]:
                idx = st.pop()
                result[idx] = i - idx
            st.append(i)
        return result

# Time Complexity: O(2n)
# Space Complexity: O(n)