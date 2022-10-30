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
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# class Solution:
#     def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
#         n = len(temperatures)
#         result = [0] * n
#         st = []
#
#         for i in range(n):
#             while len(st) > 0 and temperatures[st[-1]] < temperatures[i]:
#                 top = st.pop()
#                 result[top] = i - top
#             st.append(i)
#
#         return result
