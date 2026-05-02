# https://leetcode.com/problems/daily-temperatures/description/

# Monotonically increasing stack pattern => 2 passes
# TC: O(n)
# SC: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        re = [0] * n
        st = []

        for i in range(n):
            while st and temperatures[i] > temperatures[st[-1]]:
                popped = st.pop()
                re[popped] = i - popped
                
            st.append(i)

        return re
        

# One pass solution
# TC: O(n)
# SC: O(1)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        re = [0] * n
        hottest = 0

        for i in range(n-1, -1, -1):
            if hottest <= temperatures[i]:
                hottest = max(hottest, temperatures[i])
                continue

            days = 1
            while temperatures[i + days] <= temperatures[i]:
                days += re[i + days]

            re[i] = days

        return re