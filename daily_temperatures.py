#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        stack = []
        res = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while len(stack) > 0 and temperatures[i] > temperatures[stack[-1]]:
                popped_index = stack.pop()
                res[popped_index] = i - popped_index

            stack.append(i)

        return res
        



        