class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        st = []
        for i, j in enumerate(temperatures):
            while st and st[-1][0] < j:
                idx, top = st.pop()
                result[top] = i - top
            st.append((j, i))
        return result

# TC = O(N)
# Space complexity : List LPS O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : learned a new way of traversing through the stack using enumerate funtion
