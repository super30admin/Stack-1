# // Time Complexity :O(n)
# // Space Complexity :O(n) for all elemnts in stack
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach


class Solution:
    def dailyTemperatures(self, temperatures: list[int]) -> list[int]:
        n = len(temperatures)
        st = []
        res = [0] * n


        for i in range(n):
            while st and temperatures[i] > temperatures[st[-1]]: # monotonically increasing stack patterntemperatures
                popped = st.pop()                                # top element should be the resolved now   
                res[popped] = i - popped

            st.append(i)                                         # push index to stack


        return res