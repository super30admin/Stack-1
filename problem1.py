# Time-Complexity: O(n)
# Space Complexity: O(n)
# Leetcode status: Accepted
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        stk = []
        n = len(temperatures)
        result = [0] * n
        for i in range(n):
            while len(stk) != 0 and temperatures[i] > temperatures[stk[-1]]:
                temp = stk.pop()
                result[temp] = i - temp
            stk.append(i)
        return result
