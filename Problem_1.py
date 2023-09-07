# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        st = []
        res = ([0] * len(temperatures))
        for i in range(len(temperatures)):
            while st and temperatures[st[-1]] < temperatures[i]:
                res[st[-1]] = i - st[-1]
                st.pop()
            st.append(i)
        return res