# Tc - O(n)
# SC - O(n)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        size = len(temperatures)
        result = [0] * size
        stack = []

        for i in range(size):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                result[stack[-1]] = i - stack[-1]
                stack.pop()
            stack.append(i)

        return result
