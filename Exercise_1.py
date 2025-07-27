# S30 Problem #133 Daily Temperatures
#LeetCode #739 https://leetcode.com/problems/daily-temperatures/description/

# Author : Akaash Trivedi
# Time Complexity : O(2n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# monotonic stack
# use a staack to keep track of index until we find a warmer day
# once found a higher temp than top of stack, take difference of curr index - stack top => result for stack top idx
# if smaller temp push the element to st
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = []
        res = [0] * len(temperatures)
        for i,curr in enumerate(temperatures):
            # if current elemet is greater than the top of the stack -> pop
            while st and curr > temperatures[st[-1]]:
                popped = st.pop()
                res[popped] = i - popped
            st.append(i)
        return res
            