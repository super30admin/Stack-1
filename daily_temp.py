# Time Complexity : O(2n) => O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        n = len(temperatures)
        # final result array initialised at 0 and of same length as of temperatures
        ans = [0] * n
        st = []  # initialize an empty stack

        for curr_day, curr_temp in enumerate(temperatures):

            # Pop until the current day's temperature is not warmer than the temperature at the top of the stack
            while st and temperatures[st[-1]] < curr_temp:
                prev_day = st.pop()
                ans[prev_day] = curr_day - prev_day

            st.append(curr_day)

        return ans
